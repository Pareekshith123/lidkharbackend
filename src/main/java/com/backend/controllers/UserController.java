package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Dtos.UserDto;

import jakarta.validation.Valid;
import com.backend.service.UserService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

	public UserController() {

	}

	@Autowired
	private UserService userService;

	   @PostMapping("/create")
	    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
	        try {
	            UserDto createdUserDto = this.userService.createUser(userDto);
	            return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
	    try {
	        List<UserDto> users = this.userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	
		
}
	
	
	
		
		
		
	


