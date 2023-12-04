package com.maezia.hack.resource.core.common.config;

import com.maezia.ezia.common.exception.define.ExceptionUtils;
import com.maezia.hack.resource.common.constant.CommonConstants;
import com.maezia.hack.resource.common.domain.FeignExceptionInfo;
import com.maezia.hack.resource.common.enums.ResultCodeEnum;
import com.maezia.hack.resource.common.utils.JsonUtils;
import feign.*;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : ChenRan
 * @date ： 2023/8/2 15:58
 * Description ：FeignCustomConfig
 * project ：tgsop-tgsop-service-parent
 * dep : TT-32
 * company: MA
 */
@Slf4j
@ConditionalOnClass(RequestInterceptor.class)
public class FeignCustomConfig extends ErrorDecoder.Default implements RequestInterceptor {

    /**
     * 需要转发的请求头
     */
    private static final List<String> HEADER_NAMES = new ArrayList<String>() {{
        add(CommonConstants.HEADER_TRACE_ID);
    }};

    /**
     * 日志
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception = super.decode(methodKey, response);

        // 如果是RetryableException，则返回继续重试
        if (exception instanceof RetryableException) {
            return exception;
        }

        try {
            // 如果是FeignException，则对其进行处理，并抛出BusinessException
            if (exception instanceof FeignException && ((FeignException) exception).responseBody().isPresent()) {
                ByteBuffer responseBody = ((FeignException) exception).responseBody().get();
                String bodyText = StandardCharsets.UTF_8.newDecoder().decode(responseBody.asReadOnlyBuffer()).toString();
                log.info("FeignCustomConfig decode bodyText:{}", bodyText);

                // 将异常信息，转换为CommonExceptionInfo对象
                FeignExceptionInfo feignExceptionInfo = JsonUtils.json2Object(bodyText, FeignExceptionInfo.class);
                // 如果exceptionInfo中code不为空，则使用该code，否则使用默认的错误code
                String code = Optional.ofNullable(String.valueOf(feignExceptionInfo.getError().getCode())).orElse(ResultCodeEnum.ERROR.getCode());
                // 如果exceptionInfo中message不为空，则使用该message，否则使用默认的错误message
                String message = Optional.ofNullable(feignExceptionInfo.getError().getMessage()).orElse(ResultCodeEnum.ERROR.getMessage());
                log.info("FeignCustomConfig decode code:{}, message:{}", code, message);

                return ExceptionUtils.newBaseRuntimeException(code, message);
            }
        } catch (Exception ex) {
            log.error("FeignCustomConfig decode message:{},", ex.getMessage(), ex);
        }
        return exception;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        setHeader(requestTemplate);
    }

    /**
     * 转发请求头
     *
     * @param requestTemplate
     */
    private void setHeader(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //异步调用时attributes为null
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            for (String name : HEADER_NAMES) {
                String values = request.getHeader(name);
                log.info("FeignCustomConfig header name: {} - values: {}", name, values);
                if (null != values) {
                    requestTemplate.header(name, values);
                }
            }
        }
    }
}
