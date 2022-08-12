package com.browndwarf.jpqlex.repository;

import com.browndwarf.jpqlex.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
