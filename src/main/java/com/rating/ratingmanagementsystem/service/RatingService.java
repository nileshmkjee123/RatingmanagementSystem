package com.rating.ratingmanagementsystem.service;

import com.rating.ratingmanagementsystem.entity.Rating;
import org.springframework.stereotype.Service;


public interface RatingService {

    Rating submitRating(Rating rating);

   Rating updateRating(String id, Rating rating);

  //Rating getRating(String id);

    String deleteRating(String id);

    long countRatings();

    double avgRatings();
}
