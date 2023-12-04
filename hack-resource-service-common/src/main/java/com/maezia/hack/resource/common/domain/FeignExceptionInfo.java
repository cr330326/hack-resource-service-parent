package com.maezia.hack.resource.common.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : ChenRan
 * @date ： 2022/4/8 15:02
 * Description ：VCF调用错误封装类
 * project ：vwasp-greyservice-service-parent
 * dep : TT-32
 * company: MA
 */
@NoArgsConstructor
@Data
public class FeignExceptionInfo implements Serializable {

    private ErrorDTO error;

    @NoArgsConstructor
    @Data
    public static class ErrorDTO {

        private Integer code;

        private String message;
    }
}
