package com.tjtyres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjtyres.exception.InvalidUserdetails;
import com.tjtyres.exception.UserAlreadyException;
import com.tjtyres.exception.UserNotFoundException;
import com.tjtyres.model.User;
import com.tjtyres.model.UserRequest;
import com.tjtyres.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("v1/users")
	public User registrationUser(@RequestBody UserRequest userRequest) throws UserAlreadyException {
		
		User createUser = userService.save(userRequest);
		return createUser;
		
	}
	@PostMapping("v1/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		User findUser = userService.findByUsername(user.getUsername());
		if(findUser != null) {
			if(user.getUsername().equals(findUser.getUsername()) 
					&& user.getPassword().equals(findUser.getPassword())) {
				
				return ResponseEntity.ok(findUser);
				
			}
		}else {
			throw new InvalidUserdetails("invalid username and password");
		}
		return null;
		
	}
	@GetMapping("v1/users")
	public List<User> retriveUsers() {
		return userService.findByAll();
	}

}
