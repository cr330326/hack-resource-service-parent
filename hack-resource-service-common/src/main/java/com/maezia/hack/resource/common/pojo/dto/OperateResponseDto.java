package com.maezia.hack.resource.common.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : ChenRan
 * @date ： 2023/8/1 19:32
 * Description ：OperateResponseDto
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "响应信息")
public class OperateResponseDto implements Serializable {

    /**
     * 请求ID
     */
    @Schema(description="请求ID",type = "String",example = "1700629730000")
    private String requestId;
}
