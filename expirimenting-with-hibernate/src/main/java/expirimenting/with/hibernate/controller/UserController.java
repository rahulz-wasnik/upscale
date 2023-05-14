package expirimenting.with.hibernate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import expirimenting.with.hibernate.entity.User;
import expirimenting.with.hibernate.service.UserService;
import net.sf.ehcache.CacheManager;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		Optional<User> user = userService.get(id);
		System.out.println("Size" + CacheManager.ALL_CACHE_MANAGERS);
		return user;
	}
}
