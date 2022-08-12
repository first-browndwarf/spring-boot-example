package com.browndwarf.jpqlex.repository;

import com.browndwarf.jpqlex.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
