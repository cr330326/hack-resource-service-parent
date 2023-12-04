package com.maezia.hack.resource.core.controller;

import com.maezia.ezia.common.requestlog.annotations.RequestLog;
import com.maezia.ezia.common.result.define.Result;
import com.maezia.hack.resource.common.pojo.dto.OperateResponseDto;
import com.maezia.hack.resource.common.pojo.req.ProjectInfoRequest;
import com.maezia.hack.resource.common.pojo.req.ProjectPageRequest;
import com.maezia.hack.resource.common.pojo.vo.ProjectListVo;
import com.maezia.hack.resource.core.provider.IBusinessService;
import com.maezia.hack.resource.core.dao.entity.ProjectEntity;
import com.maezia.hack.resource.core.service.BusinessService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : ChenRan
 * @date ： 2023/8/1 18:23
 * Description ：BusinessController
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@RequestLog
@RestController
@Tag(name = "提供核心业务产品服务接口")
public class BusinessController implements IBusinessService {

    @Autowired
    private BusinessService businessService;

    /**
     * RM0001 上传项目
     * @param projectInfoRequest
     */
    @Override
    public Result<OperateResponseDto> uploadProjectInfo(ProjectInfoRequest projectInfoRequest) {
        return Result.success(businessService.requestUploadProject(projectInfoRequest));
    }

    /**
     * RM0002 获取项目列表
     */
    @Override
    public Result<List<ProjectEntity>> getProjectList() {
        return Result.success(businessService.requestProjectList());
    }

    /**
     * RM0003 获取项目详情内容
     * @param id
     */
    @Override
    public Result<ProjectEntity> getProjectById(Long id) {
        return Result.success(businessService.requestProjectById(id));
    }

    /**
     * RM0004 获取项目列表
     * @param projectPageRequest
     */
    @Override
    public Result<ProjectListVo> getProjectPageList(ProjectPageRequest projectPageRequest) {
        return Result.success(businessService.requestProjectPageList(projectPageRequest));
    }

    /**
     * RM0005 删除项目
     * @param id
     */
    @Override
    public Result<OperateResponseDto> deleteProjectById(int id) {
        return Result.success(businessService.requestDeleteProject(id));
    }
}
