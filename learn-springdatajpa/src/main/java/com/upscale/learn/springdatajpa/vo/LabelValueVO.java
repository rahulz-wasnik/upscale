package com.upscale.learn.springdatajpa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelValueVO {

	private String label;
	private String value;
	private Boolean disabled;
}
