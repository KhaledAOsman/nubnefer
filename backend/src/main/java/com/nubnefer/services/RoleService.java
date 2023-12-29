package com.nubnefer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nubnefer.entities.Role;
import com.nubnefer.repositories.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	public ResponseEntity<?> findAllRoles(){
		return ResponseEntity.ok(roleRepo.findAll());
	}
	
	public Role findRoleById(Long id){
		return roleRepo.findById(id).get();
	}
	
	public ResponseEntity<?> deleteRoleById(Long id){
		if(roleRepo.findById(id).isPresent()) {
			roleRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> updateRoleById(Long id, Role role){
		if(roleRepo.findById(id).isPresent()) {
			role.setId(id);
			return ResponseEntity.ok(roleRepo.save(role));
		}
		
		return ResponseEntity.ok(roleRepo.save(role));
	}
	
	public ResponseEntity<?> createRole(Role role){
		return new ResponseEntity<>(roleRepo.save(role),HttpStatus.CREATED);
	}
	
	
}
