package com.amstech.tripplanner.booking.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	public UserController() {
		System.out.println("User Controller : object Created ");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public void update() {
		System.out.println("update");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signUp", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> signUp(@RequestBody String body) {
		System.out.println("signUp" + body);
		return new ResponseEntity<Object>(body, HttpStatus.OK);

	}
}
