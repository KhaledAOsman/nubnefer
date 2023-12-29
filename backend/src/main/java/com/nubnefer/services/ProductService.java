package com.nubnefer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nubnefer.dto.ProductDto;
import com.nubnefer.entities.Product;
import com.nubnefer.mapper.ProductMapper;
import com.nubnefer.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ProductMapper productMapper;
	
	public List<ProductDto> findAllProducts(){
		return productMapper.mapList(productRepo.findAll());
	}
	
	public ProductDto findProductById(Long id){
		Product product = productRepo.findById(id).get();
		return productMapper.map(product);
	}
	public ProductDto createProduct(ProductDto productDto){
		Product product = productMapper.unmap(productDto);
		
		return productMapper.map(productRepo.save(product));
	}
	
	
	public ProductDto updateProductById(Long id, ProductDto productDto){
		Product product = productMapper.unmap(productDto);
		if(productRepo.findById(id).isPresent()) {
						product.setId(id);
			return productMapper.map(productRepo.save(product));
		}
		
		return productMapper.map(productRepo.save(product));
	}
	
	public ResponseEntity<?> deleteProductById(Long id){
		if(productRepo.findById(id).isPresent()) {
			productRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
