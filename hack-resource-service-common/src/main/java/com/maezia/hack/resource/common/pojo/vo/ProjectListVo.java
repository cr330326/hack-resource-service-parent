package com.maezia.hack.resource.common.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author : ChenRan
 * @date ： 2022/4/8 18:26
 * Description ProjectListVo
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "项目列表")
public class ProjectListVo implements Serializable {
    /**
     * 项目列表
     */
    @Schema(description="项目列表",type = "java.util.List")
    private List<ProjectInfoVo> records;

    /**
     * 总记录数
     */
    @Schema(description="记录总数",type = "Integer",example = "10")
    private Integer total;

    /**
     * 页码
     */
    @Schema(description="页码",type = "Integer",example = "1")
    private Integer pageNo;

    /**
     * 页数
     */
    @Schema(description="页数",type = "Integer",example = "10")
    private Integer pageSize;

}
