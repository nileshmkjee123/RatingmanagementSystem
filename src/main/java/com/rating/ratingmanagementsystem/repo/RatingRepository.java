package com.rating.ratingmanagementsystem.repo;

import com.rating.ratingmanagementsystem.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating,Long> {
}
