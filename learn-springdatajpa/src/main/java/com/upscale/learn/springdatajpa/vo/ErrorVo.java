package com.upscale.learn.springdatajpa.vo;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorVo {

	private String message;
	private HttpStatus status;
}
