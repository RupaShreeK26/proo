package com.rtofinalproject.registrations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtofinalproject.registrations.repositories.UserRepository;

@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;

}
