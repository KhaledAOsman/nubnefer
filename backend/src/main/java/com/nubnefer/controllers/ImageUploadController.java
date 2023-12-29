package com.nubnefer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nubnefer.services.ImageUploadService;

@RestController
@RequestMapping("/image")
public class ImageUploadController {
	
	@Autowired
	private ImageUploadService imageUploadService;
	
	@PostMapping("/upload/{PathType}/{id}")
	public ResponseEntity<?> uploadImage(@PathVariable Long id,@PathVariable String PathType,@RequestParam MultipartFile file){
		String FileName = imageUploadService.storeFile(id,PathType, imageUploadService.convertMultiPartFileToFile(file));
		return ResponseEntity.ok(FileName);
	}
 }
