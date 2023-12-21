package com.tranduylinh.NhaTro.controllers;

import java.util.ArrayList;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranduylinh.NhaTro.config.JwtTokenUtil;
import com.tranduylinh.NhaTro.models.User;
import com.tranduylinh.NhaTro.service.impl.UserServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@GetMapping("/login")
	public ResponseEntity<String> getToken(@RequestHeader("Authorization") String authenticate) {
		String token = new String(Base64.getDecoder().decode(authenticate.substring(6)));
		String[] jwtToken = token.split(":");
		String decodeUserName = jwtToken[0];
		String decodePassword = jwtToken[1];
		User findUserName = userServiceImpl.findUserByUserName(decodeUserName);
//		User findUserName = new User();
		
		if (findUserName != null && decodePassword.equals(findUserName.getPassword())) {
			final UserDetails userDetails = new org.springframework.security.core.userdetails.User(decodeUserName, decodePassword, new ArrayList<>());

			final String jwt = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.status(HttpStatus.OK).body(jwt);
			
			
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

		}

	}

}
