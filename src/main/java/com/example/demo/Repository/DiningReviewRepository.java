package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.DiningReview;
import com.example.demo.Entity.DiningReview.Status;
import com.example.demo.Entity.Restaurant;

import java.util.List;


public interface DiningReviewRepository extends JpaRepository<DiningReview , Long>{

    List<DiningReview> findByState(Status state);
    List<DiningReview> findByRestaurantAndStatus(Restaurant restaurant, Status state);
}
