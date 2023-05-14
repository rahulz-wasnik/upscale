package com.upscale.learn.springdatajpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upscale.learn.springdatajpa.entity.RiskProfile;
import com.upscale.learn.springdatajpa.repository.RiskProfileMetaDataRepository;
import com.upscale.learn.springdatajpa.repository.RiskProfileRepository;

@Service
public class RiskProfileServiceImpl {

	@Autowired
	private RiskProfileRepository riskProfileRepository;
	
	@Autowired
	private RiskProfileMetaDataRepository riskProfileMetaDataRepository;
	
	public List<RiskProfile> getAll() {
		return riskProfileRepository.findAll();
	}
	
	public RiskProfile create(RiskProfile riskProfile) {
		return riskProfileRepository.save(riskProfile);
	}
	
	public RiskProfile update(RiskProfile riskProfileUpdte) {
		Optional<RiskProfile> savedRiskProfileRecord = Optional.ofNullable(riskProfileRepository.findById(riskProfileUpdte.getId()).orElseThrow());
		riskProfileMetaDataRepository.deleteAllByRiskProfileId(riskProfileUpdte.getId());
		RiskProfile savedRiskProfile = savedRiskProfileRecord.get();
		savedRiskProfile.setName(riskProfileUpdte.getName());
		savedRiskProfile.setDescription(riskProfileUpdte.getDescription());
		savedRiskProfile.setActive(riskProfileUpdte.isActive());
		savedRiskProfile.setMetaData(riskProfileUpdte.getMetaData());
		savedRiskProfile.setMetaDataParts(riskProfileUpdte.getMetaDataParts());
		
		return riskProfileRepository.save(savedRiskProfile);
	}
}
