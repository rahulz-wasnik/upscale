package com.upscale.learn.springdatajpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upscale.learn.springdatajpa.vo.LabelValueVO;

@RequestMapping( path = "/riskProfile")
@RestController
public class RiskProfileController {
	
	@GetMapping
	private List<LabelValueVO> getRiskProfiles() {
		return List.of(new LabelValueVO("A1R1", "A1R1", false), new LabelValueVO("A1R2", "A1R2", false), new LabelValueVO("A1R3", "A1R3", true));
	}

	@GetMapping(path = "/{id}")
	private List<LabelValueVO> getRiskProfiles(@PathVariable String id) {
		return List.of(new LabelValueVO("A1R1", "A1R1", false), new LabelValueVO("A1R2", "A1R2", true));
	}
}
