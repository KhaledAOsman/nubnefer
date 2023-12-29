package com.nubnefer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubnefer.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
