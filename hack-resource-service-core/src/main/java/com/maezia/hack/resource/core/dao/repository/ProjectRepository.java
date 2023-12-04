package com.maezia.hack.resource.core.dao.repository;

import com.maezia.hack.resource.core.dao.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : ChenRan
 * @date ： 2023/11/22 18:29
 * Description ：ProjectRepository
 * project ：hack-resource-service-parent
 * dep : TT-32
 * company: MA
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {
}
