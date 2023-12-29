package com.nubnefer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubnefer.dto.UserDto;
import com.nubnefer.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ResponseEntity<?> findAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable Long id){
		return ResponseEntity.ok(userService.findUserById(id));		
	}
	@PostMapping("/add")
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
		return new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable Long id,@RequestBody UserDto userDto){
		return ResponseEntity.ok(userService.updateUserById(id, userDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id){
		return userService.deleteUserById(id);
	}
	
	
}
