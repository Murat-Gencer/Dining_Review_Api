package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.User;
import com.example.demo.Repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;


    public Restaurant addNewRestaurant( String name,int zipCode,int scoreOfPeanut,int scoreOfEgg,int scoreOfDairy,int overallScore){

        if(restaurantRepository.existsByNameandZipCode(name, zipCode)){
            throw new IllegalArgumentException("The restaurant is exists");
        }
        Restaurant restaurant = new Restaurant(null,name,zipCode,scoreOfPeanut,scoreOfEgg,scoreOfDairy,overallScore);
        
        return restaurantRepository.save(restaurant);

    }

    public Restaurant fetchRestaurant(Long id){
        Restaurant restaurant =restaurantRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Restaurant not found"));

        return restaurant;

    }

}
