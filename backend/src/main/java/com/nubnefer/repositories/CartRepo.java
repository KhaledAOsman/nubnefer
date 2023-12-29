package com.nubnefer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubnefer.entities.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{

}
