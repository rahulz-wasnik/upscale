package com.upscale.learn.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upscale.learn.springdatajpa.entity.ContactNumbers;

@Repository
public interface ContactNumberRepository extends JpaRepository<ContactNumbers, Long>{

}
