package com.tjtyres.service;

import java.util.List;

import com.tjtyres.exception.UserAlreadyException;
import com.tjtyres.model.User;
import com.tjtyres.model.UserRequest;

public interface UserService {
	public User save(UserRequest user)throws UserAlreadyException;
	public User findByUsername(String username);
	public List<User> findByAll();
}
