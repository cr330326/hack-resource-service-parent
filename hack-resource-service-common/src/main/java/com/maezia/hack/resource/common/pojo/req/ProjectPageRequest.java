package com.maezia.hack.resource.common.pojo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : ChenRan
 * @date ： 2023/11/22 11:24
 * Description ：ProjectPageRequest
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "项目分页入参")
public class ProjectPageRequest implements Serializable {

    /**
     * 页码
     */
    @Schema(description="页码",type = "Integer",example = "1")
    private Integer offset;

    /**
     * 页数
     */
    @Schema(description="页数",type = "Integer",example = "10")
    private Integer size;
}
