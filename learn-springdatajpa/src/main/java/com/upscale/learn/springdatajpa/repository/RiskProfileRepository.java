package com.upscale.learn.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upscale.learn.springdatajpa.entity.RiskProfile;

public interface RiskProfileRepository extends JpaRepository<RiskProfile, Long> {

}
