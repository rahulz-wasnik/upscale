package com.upscale.learn.springdatajpa.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(AirportId.class)
@Data
@NoArgsConstructor
public class Airport implements Serializable {

	private static final long serialVersionUID = -7405355278607547619L;
	
	@Id
	private Long countryCode;
	@Id
	private Long cityCode;
	private String name;

	public Airport(String name) {
		this.name = name;
	}

}
