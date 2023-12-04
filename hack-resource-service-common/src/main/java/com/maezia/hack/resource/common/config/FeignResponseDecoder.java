package com.maezia.hack.resource.common.config;

import com.maezia.hack.resource.common.constant.CommonConstants;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author : ChenRan
 * @date ： 2022/8/19 18:27
 * Description ：FeignResponseDecoder
 * project ：vwasp-greyservice-service-parent
 * dep : TT-32
 * company: MA
 */
@Slf4j
public class FeignResponseDecoder implements Decoder {
    private final SpringDecoder decoder;

    public FeignResponseDecoder(SpringDecoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        log.info("FeignResponseDecoder decode response vcf-trace-id:{}",response.headers().get(CommonConstants.HEADER_VCF_TRACE_ID));
        return this.decoder.decode(response, type);
    }
}
