package com.upscale.learn.springdatajpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upscale.learn.springdatajpa.vo.LabelValueVO;
import com.upscale.learn.springdatajpa.vo.RiskProfileVO;

@RequestMapping("/riskPolicy")
@RestController
public class RiskPolicyController {

	
	@GetMapping("/listAttributeNames") 
	public List<LabelValueVO> getAtrributeName() {
		return List.of(new LabelValueVO("vendorLicenseApplication", "vendorLicenseApplication", false), new LabelValueVO("narID", "narID", false), new LabelValueVO("x", "x", true));
	}
	
	@GetMapping("/listAttributeValues")
	public List<LabelValueVO> getAtrributeValues(@RequestParam("attributeName") String attributeName) {
		return List.of(new LabelValueVO("a", "a", false), new LabelValueVO("b", "b", false), new LabelValueVO("c", "c", true));
	}
	
	@PostMapping("/save")
	public RiskProfileVO create(@RequestBody RiskProfileVO riskPolicy) {
		return new RiskProfileVO(1, "", "", "");
	}
}
