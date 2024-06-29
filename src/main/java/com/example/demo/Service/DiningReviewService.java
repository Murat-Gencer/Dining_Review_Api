package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.DiningReview;
import com.example.demo.Entity.Restaurant;
import com.example.demo.Entity.User;
import com.example.demo.Entity.DiningReview.Status;
import com.example.demo.Repository.DiningReviewRepository;
import com.example.demo.Repository.RestaurantRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class DiningReviewService {

    @Autowired
    DiningReviewRepository diningReviewRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    public DiningReview submitDiningReview(String name, long resId,int scoreOfPeanut,int scoreOfEgg,int scoreOfDairy,String commentary,Status state){
        User user = userRepository.findByDisplayName(name).orElseThrow(()-> new IllegalArgumentException("User not found"));
        
        Restaurant restaurant = restaurantRepository.findById(resId).orElseThrow(()-> new IllegalArgumentException("Restaurant not found"));
        
        DiningReview diningReview = new DiningReview(null, name, resId, scoreOfPeanut, scoreOfEgg, scoreOfDairy, commentary, state);
        return diningReviewRepository.save(diningReview);
    }

    public List<DiningReview> getPendingReviews() {
        return diningReviewRepository.findByState(Status.PENDING);
    }

    public DiningReview reviewAction(Long reviewId, boolean approve) {
        DiningReview review = diningReviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));

        review.setState(approve ? Status.ACCEPTED : Status.REJECTED);
        return diningReviewRepository.save(review);
    }
    public List<DiningReview> getApprovedReviewsForRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        return diningReviewRepository.findByRestaurantAndStatus(restaurant, Status.ACCEPTED);
    }
}