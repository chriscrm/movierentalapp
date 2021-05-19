package com.istrategies.movierental.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.istrategies.movierental.dto.UserDTO;
import com.istrategies.movierental.request.UserDetailModel;
import com.istrategies.movierental.response.UserRest;
import com.istrategies.movierental.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(tags = "Users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/{id}")
	public UserRest getUser(@PathVariable Long id) {
		
		UserRest returnValue = new UserRest();
		
		UserDTO userDTO = userService.getUserById(id);
		BeanUtils.copyProperties(userDTO, returnValue);
		
		return returnValue;
	}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailModel userDetail) throws Exception {
		UserRest returnValue = new UserRest();
		
		
		if(userDetail.getUsername().isEmpty() || userDetail.getEmail().isEmpty()) throw new RuntimeException("Fields cannot be blank");
		
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userDetail, userDTO);
		
		UserDTO createdUser = userService.createUser(userDTO);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}

	
	@ApiOperation(value = "This method is used to get the clients.")
	@GetMapping
	public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit){
		
		List<UserRest> returnValue = new ArrayList<>();
		
		List<UserDTO> users = userService.getUsers(page, limit);
		
		for (UserDTO userDTO : users) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDTO, userModel);
			returnValue.add(userModel);
		}
		
		return returnValue;
	}
	
}
