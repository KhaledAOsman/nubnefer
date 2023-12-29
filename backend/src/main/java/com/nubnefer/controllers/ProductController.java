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

import com.nubnefer.dto.ProductDto;
import com.nubnefer.services.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public ResponseEntity<?> findAllProducts(){
		return ResponseEntity.ok(productService.findAllProducts());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findProductById(@PathVariable Long id){
		return ResponseEntity.ok(productService.findProductById(id));		
	}
	@PostMapping("/add")
	public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.createProduct(productDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProductById(@PathVariable Long id,@RequestBody ProductDto productDto){
		return ResponseEntity.ok(productService.updateProductById(id, productDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long id){
		return productService.deleteProductById(id);
	}
	
	
}
