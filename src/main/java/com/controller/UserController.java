package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.repository.AddressRepository;
import com.repository.UserRepository;
import com.entity.UserEntity;
@RestController
public class UserController {
		
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@PostMapping("/addUser")
	public UserEntity addUser(@RequestBody UserEntity user) {
		addressRepository.save(user.getAddress());
		userRepository.save(user);
		return user;
	}
	
}
