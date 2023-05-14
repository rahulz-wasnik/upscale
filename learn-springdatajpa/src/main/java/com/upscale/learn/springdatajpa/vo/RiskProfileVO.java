package com.upscale.learn.springdatajpa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskProfileVO {

	private Integer id;
	private String description;
	private String activeStatus;
	private String name;
}

