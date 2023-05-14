package com.upscale.learn.springdatajpa.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirportId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long countryCode;
    private Long cityCode;
}