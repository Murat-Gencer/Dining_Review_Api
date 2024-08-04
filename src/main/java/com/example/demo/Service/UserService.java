package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        if (userRepository.existsByDisplayName(user.getDisplayName())) {
            throw new IllegalArgumentException("Display name already exists");
        }
        
        return userRepository.save(user);
    }

    public User updateUser(String displayName , User user){
        User existingUser =userRepository.findByDisplayName(displayName).orElseThrow(()-> new IllegalArgumentException("User not found"));
        existingUser.setCity(user.getCity());
        existingUser.setState(user.getState());
        existingUser.setZipcode(user.getZipcode());
        existingUser.setInterestedInDairyAllergy(user.isInterestedInDairyAllergy());
        existingUser.setInterestedInEggAllergy(user.isInterestedInEggAllergy());
        existingUser.setInterestedInPeanutAllergy(user.isInterestedInPeanutAllergy());
        return userRepository.save(existingUser);
    }


    public User getUserByDisplayName(String displayName){
        User user =userRepository.findByDisplayName(displayName).orElseThrow(()-> new IllegalArgumentException("user not found"));
        return user;
    }

    public boolean validateUserByDisplayName(String displayName){
        return userRepository.existsByDisplayName(displayName);
    }
}
