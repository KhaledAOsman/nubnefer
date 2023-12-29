package com.nubnefer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubnefer.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{
	Optional<Users> findByUserName(String userName);
}
