package com.maezia.hack.resource.core.service.impl;

import com.maezia.hack.resource.common.pojo.dto.OperateResponseDto;
import com.maezia.hack.resource.common.pojo.req.ProjectInfoRequest;
import com.maezia.hack.resource.common.pojo.req.ProjectPageRequest;
import com.maezia.hack.resource.common.pojo.vo.ProjectInfoVo;
import com.maezia.hack.resource.common.pojo.vo.ProjectListVo;
import com.maezia.hack.resource.core.dao.entity.ProjectEntity;
import com.maezia.hack.resource.core.dao.repository.ProjectRepository;
import com.maezia.hack.resource.core.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : ChenRan
 * @date ： 2023/8/2 12:05
 * Description ：BusinessServiceImpl
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * 上传项目
     *
     * @param projectInfo
     * @return
     */
    @Override
    public OperateResponseDto requestUploadProject(ProjectInfoRequest projectInfo) {
        log.info("requestUploadProject ProjectInfoRequest:{}",projectInfo);
        ProjectEntity projectEntity = ProjectEntity.builder()
                .name(projectInfo.getProjectName())
                .code(projectInfo.getProjectCode())
                .type(projectInfo.getProjectType())
                .startDate(projectInfo.getStartDate())
                .endDate(projectInfo.getEndDate())
                .thumbUrl(projectInfo.getThumbUrl())
                .format(projectInfo.getFormat())
                .fileUrl(projectInfo.getFileUrl())
                .fileMd5(projectInfo.getFileMd5())
                .version(projectInfo.getVersion())
                .desc(projectInfo.getDesc())
                .build();
        ProjectEntity insertEntity = projectRepository.save(projectEntity);
        log.info("requestUploadProject insertEntity:{}",insertEntity);
        return OperateResponseDto.builder().requestId(String.valueOf(System.currentTimeMillis())).build();
    }

    /**
     * 获取项目列表
     * @return
     */
    @Override
    public List<ProjectEntity> requestProjectList() {
        log.info("requestProjectList start");
        return projectRepository.findAll();
    }

    /**
     * 获取项目详情内容
     *
     * @param id
     * @return
     */
    @Override
    public ProjectEntity requestProjectById(Long id) {
        log.info("requestProjectById id:{}",id);
        return projectRepository.findById(id).orElse(null);
    }

    /**
     * 获取带分页项目列表
     * ProjectPageRequest projectPageRequest
     * @return
     */
    @Override
    public ProjectListVo requestProjectPageList(ProjectPageRequest projectPageRequest) {
        log.info("requestProjectPageList projectPageRequest:{}",projectPageRequest);
        Pageable pageable = PageRequest.of(projectPageRequest.getOffset(), projectPageRequest.getSize());
        Page<ProjectEntity> page = projectRepository.findAll(pageable);
        List<ProjectEntity> projectEntityList = page.getContent();

        List<ProjectInfoVo> projectInfoList = projectEntityList.stream().map(projectEntity -> {
            ProjectInfoVo projectInfoVo = ProjectInfoVo.builder()
                    .id(projectEntity.getId())
                    .name(projectEntity.getName())
                    .code(projectEntity.getCode())
                    .type(projectEntity.getType())
                    .startDate(projectEntity.getStartDate())
                    .endDate(projectEntity.getEndDate())
                    .thumbUrl(projectEntity.getThumbUrl())
                    .format(projectEntity.getFormat())
                    .fileUrl(projectEntity.getFileUrl())
                    .fileMd5(projectEntity.getFileMd5())
                    .version(projectEntity.getVersion())
                    .desc(projectEntity.getDesc())
                    .build();
            return projectInfoVo;
        }).collect(Collectors.toList());

        ProjectListVo projectListVo = ProjectListVo.builder()
                .total((int) page.getTotalElements())
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .records(projectInfoList)
                .build();
        log.info("requestProjectPageList projectListVo:{}",projectListVo);
        return projectListVo;
    }
}
