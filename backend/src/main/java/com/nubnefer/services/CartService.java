package com.nubnefer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nubnefer.entities.Cart;
import com.nubnefer.repositories.CartRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	public ResponseEntity<?> findAllCarts(){
		return ResponseEntity.ok(cartRepo.findAll());
	}
	
	public Cart findCartById(Long id){
		return cartRepo.findById(id).get();
	}
	
	public ResponseEntity<?> deleteCartById(Long id){
		if(cartRepo.findById(id).isPresent()) {
			cartRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> updateCartById(Long id, Cart cart){
		if(cartRepo.findById(id).isPresent()) {
			cart.setId(id);
			return ResponseEntity.ok(cartRepo.save(cart));
		}
		
		return ResponseEntity.ok(cartRepo.save(cart));
	}
	
	public ResponseEntity<?> createCart(Cart cart){
		return new ResponseEntity<>(cartRepo.save(cart),HttpStatus.CREATED);
	}
	
	
}
