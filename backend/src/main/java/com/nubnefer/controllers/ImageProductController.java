package com.nubnefer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nubnefer.entities.ImageProduct;
import com.nubnefer.repositories.ImageProductRepo;
import com.nubnefer.services.ImageProductService;

@RestController
public class ImageProductController {
	
	@Autowired
	private ImageProductService imageProductService;
	
	@Autowired
	private ImageProductRepo imgProductRepo;
	
	@PostMapping("/uploadImageProduct")
	public ResponseEntity<?> uploadImage(@RequestBody ImageProduct imgProduct,@RequestParam String PathType,@RequestParam MultipartFile file){
		return new ResponseEntity<>(imageProductService.createImageProduct(imgProduct,PathType, file),HttpStatus.CREATED);
	}
	
	@GetMapping("/images")
	public ResponseEntity<?> findAllImageProduct(){
		return ResponseEntity.ok(imageProductService.findAllImageProduct());
	}

	@PostMapping("/test")
	public ImageProduct test(@RequestBody ImageProduct test) {
		return imgProductRepo.save(test);
	}
}
