package com.upscale.learn.springdatajpa.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyMatrixVO {

	private Integer id;
	private String applicationType;
	private String releaseType;
	private String riskProfile;
	private List<Integer> requiredPolicies;
}
