package expirimenting.with.hibernate.service;

import java.util.Optional;

import expirimenting.with.hibernate.entity.User;

public interface UserService {

	User registerUser(User user);
	
	Optional<User> get(Long id);
}
