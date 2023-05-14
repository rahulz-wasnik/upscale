package expirimenting.with.hibernate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import expirimenting.with.hibernate.entity.User;
import expirimenting.with.hibernate.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> get(Long id) {
		return userRepository.findById(id);
	}
}
