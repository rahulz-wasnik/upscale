package com.upscale.learn.springdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Random {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String color;
	private transient String javaOnlyTransientField; // Not persisted
	
	@Transient
	private String persistenceOnlyTransientField; // Not persisted
	
	public Random(String color, String javaOnlyTransientField, String persistenceOnlyTransientField) {
		this.color = color;
		this.javaOnlyTransientField = javaOnlyTransientField;
		this.persistenceOnlyTransientField = persistenceOnlyTransientField;
	}
}
