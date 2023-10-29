package com.rating.ratingmanagementsystem.service;

import com.rating.ratingmanagementsystem.entity.Rating;
import com.rating.ratingmanagementsystem.exception.RatingsException;
import com.rating.ratingmanagementsystem.repo.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;

//add exceptions & validations
@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {
    private RatingRepository ratingRepository;
    //private MongoTemplate mongoTemplate;
    @Override
    public Rating submitRating(Rating rating) {
      return ratingRepository.save(rating);

    }

    @Override
    public Rating updateRating(String id, Rating rating)throws RatingsException {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if(optionalRating.isPresent()){
       Rating toUpdateRating = optionalRating.get();
        toUpdateRating.setRating(rating.getRating());
        ratingRepository.save(toUpdateRating);
        return toUpdateRating;}
        throw new RatingsException("Rating with id: "+id+
                " not found");
    }


    @Override
    public String deleteRating(String id) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if(optionalRating.isPresent()){
            ratingRepository.deleteById(id);

        }
        throw new RatingsException("Rating with id: "+id+
                " not found");



    }

    @Override
    public long countRatings() {
    return ratingRepository.count();
    }

    @Override
    public double avgRatings() {
        DecimalFormat decfor = new DecimalFormat("0.0");
        return Double.valueOf(decfor.format(ratingRepository.avg()));


    }
}
