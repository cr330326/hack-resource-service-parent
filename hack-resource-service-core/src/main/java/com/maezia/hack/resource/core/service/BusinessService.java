package com.maezia.hack.resource.core.service;

import com.maezia.hack.resource.common.pojo.dto.OperateResponseDto;
import com.maezia.hack.resource.common.pojo.req.ProjectInfoRequest;
import com.maezia.hack.resource.common.pojo.req.ProjectPageRequest;
import com.maezia.hack.resource.common.pojo.vo.ProjectListVo;
import com.maezia.hack.resource.core.dao.entity.ProjectEntity;

import java.util.List;

/**
 * @author : ChenRan
 * @date ： 2023/8/2 11:57
 * Description ：BusinessService
 * project ：tgsop-tgsop-service-parent
 * dep : TT-32
 * company: MA
 */
public interface BusinessService {

    /**
     * 上传项目
     *
     * @param projectInfo
     * @return
     */
    OperateResponseDto requestUploadProject(ProjectInfoRequest projectInfo);

    /**
     * 获取项目列表
     * @return
     */
    List<ProjectEntity> requestProjectList();

    /**
     * 获取项目详情内容
     *
     * @param id
     * @return
     */
    ProjectEntity requestProjectById(Long id);

    /**
     * 获取带分页项目列表
     * @param projectPageRequest 分页请求参数
     * @return
     */
    ProjectListVo requestProjectPageList(ProjectPageRequest projectPageRequest);

    /**
     * 删除项目
     *
     * @param id
     * @return
     */
    OperateResponseDto requestDeleteProject(int id);
}
