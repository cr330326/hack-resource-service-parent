package com.maezia.hack.resource.common.utils;

import com.ezia.coreservices.common.enumeration.error.businessunit.ErrorcodeEnum;
import com.maezia.ezia.common.exception.define.BaseRuntimeException;
import com.maezia.ezia.common.exceptionhandler.CommonErrorCodeEnum;
import com.maezia.ezia.common.result.define.Result;

/**
 * @author : ChenRan
 * @date ： 2022/9/19 11:22
 * Description ：ResultUtils
 * project ：vwasp-greyservice-service-parent
 * dep : TT-32
 * company: MA
 */
public final class ResultUtils {

    private ResultUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static final Integer SUCCESS_CODE = 0;

    private static final Integer ERROR_CODE = -1;

    private static final Integer MESSAGE_LENGTH = 2;

    public static final String EN_US = "en";

    public static final String ZH_CN = "zh";

    private static final String CHARACTER_COMMA = "_##_";

    private static final String CHARACTER_COLON = ":";

    /**
     * 失败结果转换
     *
     * @param error 通用error枚举
     * @param <T>   业务数据范型
     * @return Result<T>
     */
    public static <T> Result<T> covertSystemError(CommonErrorCodeEnum error) {
        return getResultError(error.getCode(), error.getShowMessage(), null);
    }

    /**
     * 失败结果转换
     *
     * @param error 通用error枚举
     * @param errorMessage 错误信息
     * @param <T>   业务数据范型
     * @return Result<T>
     */
    public static <T> Result<T> covertSystemError(CommonErrorCodeEnum error,String errorMessage) {
        return getResultError(error.getCode(),errorMessage,null);
    }

    /**
     * 失败结果转换
     *
     * @param error 通用error枚举
     * @param data  业务数据
     * @param <T>   业务数据范型
     * @return Result<T>
     */
    public static <T> Result<T> covertSystemError(CommonErrorCodeEnum error, T data) {
        return getResultError(error.getCode(), error.getShowMessage(), data);
    }


    /**
     * 失败结果转换
     *
     * @param errorCode 错误码
     * @param errorMessage 错误消息
     * @return Result<T>
     */
    public static  <T> Result<T> covertResultError(String errorCode,String errorMessage) {
        return getResultError(errorCode,errorMessage,null);
    }

    /**
     * 成功结果转换
     *
     * @param <T>   业务数据范型
     * @return Result<T>
     */
    public static <T> Result<T> covertResultSuccess(T data) {
        return getResultSuccess(data);
    }

    /**
     * 失败结果转换
     *
     * @param error 通用error枚举
     * @return Result<T>
     */
    public static BaseRuntimeException covertError(ErrorcodeEnum error) {
        return new BaseRuntimeException(error.getValue(), error.getShowMessage());
    }

    /**
     * 获取ResultError结果
     *
     * @param errorCode 错误码
     * @param errorMessage 错误消息
     * @param data 数据
     * @return Result<T>
     */
    private static<T> Result getResultError(String errorCode,String errorMessage,T data){
        Result<T> errorResult = new Result<>();
        errorResult.setTraceId(TraceIdUtils.getTraceId());
        errorResult.setRespCode(ERROR_CODE);
        errorResult.setErrorCode(errorCode);
        errorResult.setRespMsg(errorMessage);
        errorResult.setData(data);
        return errorResult;
    }

    /**
     * 获取ResultSuccess结果
     * @param data 数据
     * @return Result<T>
     */
    private static <T> Result<T> getResultSuccess(T data) {
        Result<T> successResult = new Result<>();
        successResult.setTraceId(TraceIdUtils.getTraceId());
        successResult.setRespCode(0);
        successResult.setErrorCode(Result.SUCCESS_CODE);
        successResult.setRespMsg(Result.SUCCESS);
        successResult.setData(data);
        return successResult;
    }
}
