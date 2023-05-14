package com.upscale.learn.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upscale.learn.springdatajpa.entity.Airport;
import com.upscale.learn.springdatajpa.entity.AirportId;

public interface AirportRepository extends JpaRepository<Airport, AirportId> {

}
