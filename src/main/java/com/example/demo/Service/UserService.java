package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String displayName , String city , String state , String zipcode , boolean peanutAllergy, boolean eggAllergy,boolean dairyAllergy){
        if (userRepository.existsByDisplayName(displayName)) {
            throw new IllegalArgumentException("Display name already exists");
        }
        User user = new User(null, displayName, city, state, zipcode, peanutAllergy, eggAllergy, dairyAllergy);
        return userRepository.save(user);
    }

    public User updateUser(Long userId,String city , String state , String zipcode , boolean peanutAllergy, boolean eggAllergy,boolean dairyAllergy){
        User user =userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User not found"));
        user.setCity(city);
        user.setState(state);
        user.setZipcode(zipcode);
        user.setInterestedInDairyAllergy(dairyAllergy);
        user.setInterestedInEggAllergy(eggAllergy);
        user.setInterestedInPeanutAllergy(peanutAllergy);
        return userRepository.save(user);
    }


    public User getUserByDisplayName(String displayName){
        User user =userRepository.findByDisplayName(displayName).orElseThrow(()-> new IllegalArgumentException("user not found"));
        return user;
    }

    public boolean validateUserByDisplayName(String displayName){
        return userRepository.existsByDisplayName(displayName);
    }
}
