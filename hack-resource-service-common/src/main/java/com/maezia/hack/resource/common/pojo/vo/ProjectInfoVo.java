package com.maezia.hack.resource.common.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : ChenRan
 * @date ： 2022/4/8 18:26
 * Description ProjectInfoDto
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "项目信息")
public class ProjectInfoVo implements Serializable {

    /**
     * 主键id
     */
    @Schema(description="主键id",type = "Long",example = "1")
    private Long id;

    /**
     * 项目名称
     */
    @Schema(description="项目名称",type = "String",example = "POC项目")
    private String name;

    /**
     * 项目编码
     */
    @Schema(description="项目编码",type = "String",example = "008")
    private String code;

    /**
     * 项目类型 1-POC 2-SOP
     */
    @Schema(description="项目类型",type = "Integer",example = "1")
    private Integer type;

    /**
     * 开始日期
     */
    @Schema(description="开始日期",type = "String",example = "2022-11-22")
    private String startDate;

    /**
     * 结束日期
     */
    @Schema(description="结束日期",type = "String",example = "2023-11-22")
    private String endDate;

    /**
     * 缩略图地址
     */
    @Schema(description="缩略图地址",type = "String",example = "https://avatar-vwasp-noprod-cdn.maezia.com/d15978d085df0a2ff4f4462be0f6fd96.png")
    private String thumbUrl;

    /**
     * 缩略图格式
     */
    @Schema(description="缩略图格式",type = "Integer",example = "1")
    private Integer format;

    /**
     * 资源地址
     */
    @Schema(description="资源地址",type = "String",example = "https://avatar-vwasp-noprod-cdn.maezia.com/1.0.0_1698918296321.zip")
    private String fileUrl;

    /**
     * 资源MD5值
     */
    @Schema(description="资源MD5值",type = "String",example = "78c20f991ac99f4ff405bd97a76c858b")
    private String fileMd5;

    /**
     * 版本号
     */
    @Schema(description="版本号",type = "String",example = "0.0.1")
    private String version;

    /**
     * 描述信息
     */
    @Schema(description="描述信息",type = "String",example = "test")
    private String desc;



}
