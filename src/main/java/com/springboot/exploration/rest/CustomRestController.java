package com.springboot.exploration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exploration.model.User;
import com.springboot.exploration.service.UserService;

@RestController
public class CustomRestController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/test")
	public ResponseEntity<List<User>> test() {

		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
}