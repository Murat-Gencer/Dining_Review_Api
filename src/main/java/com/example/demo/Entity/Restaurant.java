package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int scoreOfPeanut;
    public int scoreOfEgg;
    public int scoreOfDairy;
    public int overallScore;

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getScoreOfPeanut() {
        return scoreOfPeanut;
    }
    public void setScoreOfPeanut(int scoreOfPeanut) {
        this.scoreOfPeanut = scoreOfPeanut;
    }
    public int getScoreOfEgg() {
        return scoreOfEgg;
    }
    public void setScoreOfEgg(int scoreOfEgg) {
        this.scoreOfEgg = scoreOfEgg;
    }
    public int getScoreOfDairy() {
        return scoreOfDairy;
    }
    public void setScoreOfDairy(int scoreOfDairy) {
        this.scoreOfDairy = scoreOfDairy;
    }
    public int getOverallScore() {
        return overallScore;
    }
    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }
}
