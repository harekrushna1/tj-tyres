package com.tjtyres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjtyres.controller.exception.UserNotFoundException;
import com.tjtyres.exception.UserAlreadyException;
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
	public String loginUser(@RequestBody User user) {
		User findUser = userService.findByUsername(user.getUsername());
		System.out.println("find user" + findUser);
		if(findUser != null) {
			if(user.getUsername().equals(findUser.getUsername()) 
					&& user.getPassword().equals(findUser.getPassword())) {
				
				return "user loged in successfully";
				
			}else{
				
				return "username and password invalid, please try again";
				
			}
		}
		return null;
		
		
	}
	@GetMapping("v1/users")
	public List<User> retriveUsers() {
		return userService.findByAll();
	}

}
