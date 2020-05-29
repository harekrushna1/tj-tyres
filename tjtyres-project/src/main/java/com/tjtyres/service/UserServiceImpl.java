package com.tjtyres.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjtyres.exception.UserAlreadyException;
import com.tjtyres.model.Role;
import com.tjtyres.model.User;
import com.tjtyres.model.UserRequest;
import com.tjtyres.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	


	@Override
	public User save(UserRequest userRequest)throws UserAlreadyException{
		
		User user = new User();
		user.setUsername(userRequest.getUsername());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		User findUser = userRepository.findByEmail(user.getEmail());
			if(findUser != null) {
				 throw new UserAlreadyException("already exist username please give other username:");	
				 
			}
		Set<Role> userSet = new HashSet<>();
		for(String role: userRequest.getRole()) {
			Role r1 = new Role();
			r1.setRole(role);
			userSet.add(r1);
		}
		user.setRoles(userSet);
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> findByAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	/*
	 * @Override public boolean checkUserExist(User user) { boolean userExistFlag =
	 * userRepository.checkUserExist(user); return userExistFlag; }
	 */

}
