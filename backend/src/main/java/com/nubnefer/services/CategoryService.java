package com.nubnefer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nubnefer.entities.Category;
import com.nubnefer.repositories.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categorytRepo;
	
	public ResponseEntity<?> findAllCategory(){
		return ResponseEntity.ok(categorytRepo.findAll());
	}
	
	public Category findCategoryById(Long id){
		return categorytRepo.findById(id).get();
	}
	
	public ResponseEntity<?> deleteCategoryById(Long id){
		if(categorytRepo.findById(id).isPresent()) {
			categorytRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> updateCategoryById(Long id, Category category){
		if(categorytRepo.findById(id).isPresent()) {
			category.setId(id);
			return ResponseEntity.ok(categorytRepo.save(category));
		}
		
		return ResponseEntity.ok(categorytRepo.save(category));
	}
	
	public ResponseEntity<?> createCategory(Category category){
		return new ResponseEntity<>(categorytRepo.save(category),HttpStatus.CREATED);
	}	
}
