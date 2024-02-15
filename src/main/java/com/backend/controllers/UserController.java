package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.backend.Dtos.UserDto;

import jakarta.validation.Valid;
import com.backend.service.UserService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {

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
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUser() {



	    try {
	        List<UserDto> users = this.userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	// Corrected @PutMapping
	@PutMapping("/update/{id}") // Use {id} instead of {$id}
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {

	    try {
	        UserDto user = this.userService.updateUser(id, userDto);
	        return new ResponseEntity<>(user, HttpStatus.ACCEPTED); // Simplified ResponseEntity
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	// Corrected @GetMapping
	@GetMapping("/{id}") // Use {id} instead of {$id}
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {

	    try {
	        UserDto userDto = this.userService.getUserById(id);
	        return new ResponseEntity<>(userDto, HttpStatus.OK); // Simplified ResponseEntity
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Change to NOT_FOUND if an exception occurs
	    }
	}
 @DeleteMapping("/{id}")
 public String deleteUser(@PathVariable Integer id){
	 try {
		this.userService.deleteUser(id);
		String message="The User is Deleted Successfully";
		return message; 
	} catch (Exception e) {
		String messageString="Could't delete the User!";
		return messageString;
		// TODO: handle exception
	}
 }
	
		
}
	
	
	
		
		
		
	


