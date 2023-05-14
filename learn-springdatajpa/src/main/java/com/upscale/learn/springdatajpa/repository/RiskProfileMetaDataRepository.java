package com.upscale.learn.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.upscale.learn.springdatajpa.entity.RiskProfileMetaData;

public interface RiskProfileMetaDataRepository extends JpaRepository<RiskProfileMetaData, Long> {
	
	@Transactional
	void deleteAllByRiskProfileId(Long id);

}

