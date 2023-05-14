package com.upscale.learn.springdatajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upscale.learn.springdatajpa.vo.PolicyMatrixVO;

@RestController
@RequestMapping(path = "/policyMatrix")
public class PolicyMatrixController {

	@GetMapping
    public List<PolicyMatrixVO> getPoliyMatrix() {
    	
		List<PolicyMatrixVO> policyMatrixVOs = new ArrayList<>();
    	
		policyMatrixVOs.add(new PolicyMatrixVO(
 				1,
 				"A1",
 				"1",
 				"A1R2",
 				List.of(1,2)));
    	
		policyMatrixVOs.add(new PolicyMatrixVO(
 				1,
 				"A1",
 				"1",
 				"A1R3",
 				List.of(1)));
    	return policyMatrixVOs;
    }

	@GetMapping(path = "/{id}")
	public PolicyMatrixVO getPoliyMatrix(@PathVariable String id) {
		PolicyMatrixVO policyMatrixVO = new PolicyMatrixVO(1, "A1", "1", "A1R1", List.of(1));
		return policyMatrixVO;
	}

	@PostMapping(produces = "text/plain", consumes = "application/json")
	public String createPolicy() {
		return "Policy created";
	}

	@PutMapping(path = "/{id}")
	public String update() {
		return "updated";
	}

	@DeleteMapping(path = "/{id}")
	public String delete() {
		return "Deleted";
	}
	
}

