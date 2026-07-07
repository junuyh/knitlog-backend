package com.knitlog.backend.domain.yarn;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YarnColorRepository extends JpaRepository<YarnColor, Long> {
    List<YarnColor> findByYarnInfoId(Long yarnInfoId);
}
