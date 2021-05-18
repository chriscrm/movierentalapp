package com.istrategies.movierental.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.istrategies.movierental.dto.UserDTO;
import com.istrategies.movierental.entity.UserEntity;
import com.istrategies.movierental.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	//Autowire UserRepository, BCrypt
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserEntity userEntity = userRepo.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(MessageFormat.format("Could not find the user with email: {0}", email));

		return new User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
	}

	/**
	 * <p>Creating user method implementation
	 * @param UserDTO user
	 * @return user Data Transfer Object copying properties from UserEntity to UserDTO
	 */
	@Override
	public UserDTO createUser(UserDTO user) {

		UserDTO returnValue = new UserDTO();
		
		if(userRepo.findByEmail(user.getEmail()) != null) throw new RuntimeException("User Email already exists"); 
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		UserEntity storedUserDetail = userRepo.save(userEntity);
		BeanUtils.copyProperties(storedUserDetail, returnValue);
		
		return returnValue;
	}

	/**
	 * <p>Get user method implementation
	 * @param String user email
	 * @return user Data Transfer Object copying properties from UserEntity to UserDTO
	 */
	@Override
	public UserDTO getUser(String email) {
		UserEntity userEntity = userRepo.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		//Using Data Transfer Object
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}

	/**
	 * <p>Get user by Id method implementation
	 * @param Long userId
	 * @return user Data Transfer Object copying properties from UserEntity to UserDTO
	 */
	@Override
	public UserDTO getUserById(Long userId) {
		UserDTO returnValue = new UserDTO();
		
		Optional<UserEntity> userEntity = userRepo.findById(userId);
		
		if (userEntity == null) throw new UsernameNotFoundException(MessageFormat.format("User with id {0} not found.", userId));
		
		BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}
	
	/**
	 * <p>Get all user method implementation
	 * @param page and limit for paging 
	 * @return List of User Data Transfer Object
	 */
	@Override
	public List<UserDTO> getUsers(int page, int limit) {

		List<UserDTO> returnValue = new ArrayList<>();

		if (page > 0)
			page -= 1;

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<UserEntity> usersPage = userRepo.findAll(pageableRequest);

		List<UserEntity> users = usersPage.getContent();

		for (UserEntity userEntity : users) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(userEntity, userDTO);
			returnValue.add(userDTO);
		}

		return returnValue;
	}

	
}













