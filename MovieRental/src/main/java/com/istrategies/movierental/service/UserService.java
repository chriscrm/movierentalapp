package com.istrategies.movierental.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.istrategies.movierental.dto.UserDTO;

public interface UserService extends UserDetailsService {

	UserDTO createUser(UserDTO user);
	UserDTO getUser(String email);
	UserDTO getUserById(Long userId);
	List<UserDTO> getUsers(int page, int limit);
	
}
