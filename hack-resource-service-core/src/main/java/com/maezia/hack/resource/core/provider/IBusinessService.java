package com.maezia.hack.resource.core.provider;

import com.maezia.ezia.common.result.define.Result;
import com.maezia.hack.resource.common.pojo.dto.OperateResponseDto;
import com.maezia.hack.resource.common.pojo.req.ProjectInfoRequest;
import com.maezia.hack.resource.common.pojo.req.ProjectPageRequest;
import com.maezia.hack.resource.common.pojo.vo.ProjectListVo;
import com.maezia.hack.resource.core.dao.entity.ProjectEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : ChenRan
 * @date ： 2023/8/1 19:10
 * Description ：IBusinessService
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
public interface IBusinessService {

    /**
     * RM0001 上传项目
     * @param projectInfo
     * @return
     */
    @Operation(summary = "RM0001 上传项目", method = "POST")
    @PostMapping("/hack/api/v1/project/upload/info")
    Result<OperateResponseDto> uploadProjectInfo(@RequestBody ProjectInfoRequest projectInfo);

    /**
     * RM0002 获取项目列表
     * @return
     */
    @Operation(summary = "RM0002 获取项目列表",method = "GET")
    @GetMapping("/hack/api/v1/project/list")
    Result<List<ProjectEntity>> getProjectList();

    /**
     * RM0003 获取项目详情内容
     * @param id
     * @return
     */
    @Operation(summary = "RM0003 获取项目详情内容",method = "GET")
    @GetMapping("/hack/api/v1/project/detail")
    Result<ProjectEntity> getProjectById(@RequestParam(value = "id") Long id);


    /**
     * RM0004 获取带分页项目列表
     * @param projectPageRequest 分页请求参数
     * @return
     */
    @Operation(summary = "RM0004 获取带分页项目列表",method = "POST")
    @PostMapping("/hack/api/v1/project/page/list")
    Result<ProjectListVo> getProjectPageList(@RequestBody ProjectPageRequest projectPageRequest);

    /**
     * RM0005 删除项目
     * @param id
     * @return
     */
    @Operation(summary = "RM0001 上传项目", method = "DELETE")
    @DeleteMapping("/hack/api/v1/project/delete/{id}")
    Result<OperateResponseDto> deleteProjectById(@PathVariable("id") int id);

}
