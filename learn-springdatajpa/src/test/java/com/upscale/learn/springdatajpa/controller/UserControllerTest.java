package com.upscale.learn.springdatajpa.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.github.javafaker.Faker;
import com.upscale.learn.springdatajpa.ResourceNotFoundException;
import com.upscale.learn.springdatajpa.entity.User;
import com.upscale.learn.springdatajpa.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@MockBean
	private UserService userService;

	@MockBean
	private Faker faker;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldGetAUserBasedOnId() throws Exception {
		Long id = 1L;
		when(userService.get(id)).thenReturn(new User("first", "last", null, null));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(jsonPath("$.firstName").value("first"))
			.andDo(print());
	}
	
	@Test
	void shouldReturnEmptyWhenUserIsNotFoundBasedOnId() throws Exception {
		Long id = 1L;
		when(userService.get(id)).thenThrow(new ResourceNotFoundException());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id))
		.andExpect(MockMvcResultMatchers.status().isNotFound())
		.andDo(print());
	}
	
	
}
