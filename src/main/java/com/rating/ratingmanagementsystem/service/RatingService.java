package com.rating.ratingmanagementsystem.service;

import com.rating.ratingmanagementsystem.entity.Rating;
import com.rating.ratingmanagementsystem.exception.RatingsException;
import org.springframework.stereotype.Service;


public interface RatingService {

    Rating submitRating(Rating rating);

   Rating updateRating(String id, Rating rating)throws RatingsException;

  //Rating getRating(String id);

    String deleteRating(String id)throws RatingsException;

    long countRatings();

    double avgRatings();
}
