package com.upscale.learn.springdatajpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upscale.learn.springdatajpa.vo.LabelValueVO;
import com.upscale.learn.springdatajpa.vo.PolciyVO;
import com.upscale.learn.springdatajpa.vo.RiskProfileVO;

@RequestMapping("/policy")
@RestController
public class PolicyController {

	
	@GetMapping() 
	public List<PolciyVO> get() {
		return List.of(new PolciyVO(1, "P1"), new PolciyVO(2, "P2"));
	}
	
}
