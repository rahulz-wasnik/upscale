package com.upscale.learn.springdatajpa.repository;

import com.upscale.learn.springdatajpa.entity.Random;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomRepository extends JpaRepository<Random, Long> {

}
