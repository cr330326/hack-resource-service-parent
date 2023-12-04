package com.maezia.hack.resource.common.enums;

import lombok.Getter;

/**
 * @author : ChenRan
 * @date ： 2022/4/8 16:16
 * Description ：ResultCodeEnum
 * project ：vwasp-greyservice-service-parent
 * dep : TT-32
 * company: MA
 */
@Getter
public enum ResultCodeEnum {
    /**
     * base
     */
    SUCCESS("0", "success"),
    ERROR("-1", "request error"),
    ERROR_MICROSERVICES("500", "Internal Server Error"),
    ;

    private final String code;
    private final String message;

    ResultCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
