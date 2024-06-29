package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByDisplayName(String displayName);
    boolean existsByDisplayName(String displayName);
    
}
