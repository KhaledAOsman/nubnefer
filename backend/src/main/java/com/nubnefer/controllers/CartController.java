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

import com.nubnefer.entities.Cart;
import com.nubnefer.services.CartService;


@RestController
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("")
	public ResponseEntity<?> findAllCarts(){
		return cartService.findAllCarts();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findCartById(@PathVariable Long id){
		return ResponseEntity.ok(cartService.findCartById(id));		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCartById(@PathVariable Long id){
		return cartService.deleteCartById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCartById(@PathVariable Long id,@RequestBody Cart cart){
		return cartService.updateCartById(id, cart);
	}
	@PostMapping("/add")
	public ResponseEntity<?> createCart(@RequestBody Cart cart){
		return cartService.createCart(cart);
	}
	
}
