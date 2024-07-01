package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Restaurant;



public interface RestaurantRepository extends JpaRepository<Restaurant , Long> {

    Optional<Restaurant> getById(long id);
    boolean existsByNameandZipCode(String name , int zipCode);
    boolean existsById(Long id);
}
