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

import com.nubnefer.entities.Category;
import com.nubnefer.services.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public ResponseEntity<?> findAllCategory(){
		return categoryService.findAllCategory();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findCategoryById(@PathVariable Long id){
		return ResponseEntity.ok(categoryService.findCategoryById(id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){
		return categoryService.deleteCategoryById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCategoryById(@PathVariable Long id,@RequestBody Category category){
		return categoryService.updateCategoryById(id, category);
	}
	@PostMapping("/add")
	public ResponseEntity<?> createCategory(@RequestBody Category category){
		return categoryService.createCategory(category);
	}
	
	
	
}
