package com.maezia.hack.resource.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : ChenRan
 * @date ： 2022/3/30 13:00
 * Description ：通用列表返回对象
 * project ：vwasp-greyservice-service-parent
 * dep : TT-32
 * company: MA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonListResult<T> {

    /**
     * 数据封装
     */
    private List<T> data;
}
