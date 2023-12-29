package com.nubnefer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubnefer.entities.Role;
import com.nubnefer.services.RoleService;


@RestController
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public ResponseEntity<?> findAllRoles(){
		return roleService.findAllRoles();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findRoleById(@PathVariable Long id){
		return ResponseEntity.ok(roleService.findRoleById(id));		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRoleById(@PathVariable Long id){
		return roleService.deleteRoleById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateRoleById(@PathVariable Long id,@RequestBody Role role){
		return roleService.updateRoleById(id, role);
	}
	@PostMapping("/add")
	public ResponseEntity<?> createRole(@RequestBody Role role){
		return roleService.createRole(role);
	}
	
}
