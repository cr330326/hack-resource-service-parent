package com.maezia.hack.resource.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author : ChenRan
 * @date ： 2022/3/30 13:00
 * Description ：通用请求返回对象
 * project ：vwasp-greyservice-service-parent
 * dep : TT-32
 * company: MA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * 数据封装
     */
    private T data;
}
