package com.rating.ratingmanagementsystem.repo;

import com.rating.ratingmanagementsystem.entity.Rating;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$avg:$rating }}}" })
    public double avg();

}
