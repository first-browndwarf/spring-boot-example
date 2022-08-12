package com.browndwarf.jpqlex.repository;

import com.browndwarf.jpqlex.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
