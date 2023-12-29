package com.nubnefer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nubnefer.dto.UserDto;
import com.nubnefer.entities.Users;
import com.nubnefer.mapper.UserMapper;
import com.nubnefer.repositories.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserDto> findAllUsers(){
		return userMapper.mapList(userRepo.findAll());
	}
	
	public UserDto findUserById(Long id){
		Users user = userRepo.findById(id).get();
		return userMapper.map(user);
	}
	public UserDto createUser(UserDto userDto){
		Users user = userMapper.unmap(userDto);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userMapper.map(userRepo.save(user));
	}
	
	
	public UserDto updateUserById(Long id, UserDto userDto){
		Users user = userMapper.unmap(userDto);
		if(userRepo.findById(id).isPresent()) {
						user.setId(id);
			return userMapper.map(userRepo.save(user));
		}
		
		return userMapper.map(userRepo.save(user));
	}
	
	public ResponseEntity<?> deleteUserById(Long id){
		if(userRepo.findById(id).isPresent()) {
			userRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> user = userRepo.findByUserName(username);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException(username + ": this user not found");
		}
		return new User(user.get().getUserName(),user.get().getPassword(),getAuthorities(user.get()));
	}
	
	private static List<GrantedAuthority> getAuthorities(Users user) {
	
	List<GrantedAuthority> authorities = new ArrayList<>();
	
	 if(user.getRole().getName() != "") {
		 authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
	 }
	     return authorities;
	}
	
	
}
