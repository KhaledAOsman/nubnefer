package com.nubnefer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nubnefer.services.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {

	
//		UserDto user1 = new UserDto(null,"test", "test", 1L, null, "test");
//		userService.createUser(user1);
			
	}

}
