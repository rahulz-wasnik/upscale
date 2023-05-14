package com.upscale.learn.springdatajpa.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.upscale.learn.springdatajpa.ResourceNotFoundException;
import com.upscale.learn.springdatajpa.vo.ErrorVo;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorVo> exception(ResourceNotFoundException exception) {
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
