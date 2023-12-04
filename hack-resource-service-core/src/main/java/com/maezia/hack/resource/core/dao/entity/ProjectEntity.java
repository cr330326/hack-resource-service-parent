package com.maezia.hack.resource.core.dao.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : ChenRan
 * @date ： 2023/11/22 18:16
 * Description ：ProjectEntity
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
@Schema(description = "项目信息")
public class ProjectEntity implements Serializable{

    /**
     * 主键id
     */
    @Id
    @Schema(description="主键id",type = "Long",example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 项目名称
     */
    @Column(name = "name")
    @Schema(description="项目名称",type = "String",example = "POC项目")
    private String name;

    /**
     * 项目编码
     */
    @Column(name = "code")
    @Schema(description="项目编码",type = "String",example = "008")
    private String code;

    /**
     * 项目类型 1-POC 2-SOP
     */
    @Column(name = "type")
    @Schema(description="项目类型",type = "Integer",example = "1")
    private Integer type;

    /**
     * 开始日期
     */
    @Column(name = "start_date")
    @Schema(description="开始日期",type = "String",example = "2022-11-22")
    private String startDate;

    /**
     * 结束日期
     */
    @Column(name = "end_date")
    @Schema(description="结束日期",type = "String",example = "2023-11-22")
    private String endDate;

    /**
     * 缩略图地址
     */
    @Column(name = "thumb_url")
    @Schema(description="缩略图地址",type = "String",example = "https://avatar-vwasp-noprod-cdn.maezia.com/d15978d085df0a2ff4f4462be0f6fd96.png")
    private String thumbUrl;

    /**
     * 缩略图格式
     */
    @Column(name = "format")
    @Schema(description="缩略图格式",type = "Integer",example = "1")
    private Integer format;

    /**
     * 资源地址
     */
    @Column(name = "file_url")
    @Schema(description="资源地址",type = "String",example = "https://avatar-vwasp-noprod-cdn.maezia.com/1.0.0_1698918296321.zip")
    private String fileUrl;

    /**
     * 资源MD5值
     */
    @Column(name = "file_md5")
    @Schema(description="资源MD5值",type = "String",example = "78c20f991ac99f4ff405bd97a76c858b")
    private String fileMd5;

    /**
     * 版本号
     */
    @Column(name = "version")
    @Schema(description="版本号",type = "String",example = "0.0.1")
    private String version;

    /**
     * 描述信息
     */
    @Column(name = "desc")
    @Schema(description="描述信息",type = "String",example = "test")
    private String desc;
}
