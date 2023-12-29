package com.nubnefer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nubnefer.entities.ImageProduct;
import com.nubnefer.repositories.ImageProductRepo;

@Service
public class ImageProductService {

	@Autowired
	private ImageProductRepo imageProductRepo;
	
	@Autowired
	private ImageUploadService imgUploadService;
	
	public List<ImageProduct> findAllImageProduct(){
		return imageProductRepo.findAll();
	}
	
	public ImageProduct findImageProductById(Long id){
		return imageProductRepo.findById(id).get();
	}
	
	public ResponseEntity<?> deleteImageProductById(Long id){
		if(imageProductRepo.findById(id).isPresent()) {
			imageProductRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> updateImageProductById(Long id, ImageProduct imageProduct){
		if(imageProductRepo.findById(id).isPresent()) {
			imageProduct.setId(id);
			return ResponseEntity.ok(imageProductRepo.save(imageProduct));
		}
		
		return ResponseEntity.ok(imageProductRepo.save(imageProduct));
	}
	
	public ImageProduct createImageProduct(ImageProduct imgProduct, String pathType, MultipartFile file){
		String url = imgUploadService.storeFile(pathType, imgUploadService.convertMultiPartFileToFile(file));
//		ImageProduct imgProduct = new ImageProduct();
//		
//		imgProduct.setUrl(url);
		imgProduct.setUrl(url);
		return imageProductRepo.save(imgProduct);
	}
}
