package com.upscale.learn.springdatajpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upscale.learn.springdatajpa.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByFirstName(String firstName);
	
	public Optional<User> findUsingLastName(String firstName);

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "insert into User (firstName, lastName) values (:firstName, :lastName)")
	public void insertUser(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
