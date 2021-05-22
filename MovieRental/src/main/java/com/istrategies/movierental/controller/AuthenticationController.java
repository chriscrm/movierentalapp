package com.istrategies.movierental.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.istrategies.movierental.request.UserLoginRequestModel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@RestController
public class AuthenticationController {

	/**
	 * 
	 * @param loginRequestModel
	 */
	@ApiOperation("User login")
	@ApiResponses(value = {
			@ApiResponse(code = 200,
					message = "Response Headers",
					responseHeaders = {
							@ResponseHeader(name = "authorization",
									description = "<JWT value here>",
									response = String.class),
							@ResponseHeader(name = "userId",
									description = "User ID value here",
									response = String.class)})
	})
	@PostMapping("/users/login")
	public void fakeLogin(@RequestBody UserLoginRequestModel loginRequestModel) {
		throw new IllegalStateException("This method sould not be called. This method is implemented by Spring Security");
	}
	
}
