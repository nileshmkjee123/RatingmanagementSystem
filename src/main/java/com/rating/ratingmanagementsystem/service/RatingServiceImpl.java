package com.rating.ratingmanagementsystem.service;

import com.rating.ratingmanagementsystem.entity.Rating;
import com.rating.ratingmanagementsystem.repo.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Rating updateRating(String id, Rating rating) {
        Rating toUpdateRating = ratingRepository.findById(id).get();
        toUpdateRating.setRating(rating.getRating());
        ratingRepository.save(toUpdateRating);
        return toUpdateRating;
    }

//    @Override
//    public Rating getRating(String id) {
//        return ratingRepository.findById(id).get();
//
//    }

    @Override
    public String deleteRating(String id) {
        ratingRepository.deleteById(id);
        return "Rating for "+id+" is removed";

    }

    @Override
    public long countRatings() {

//        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//            MongoDatabase database = mongoClient.getDatabase("ratings");
//            MongoCollection<Document> collection = database.getCollection("ratings");
//
//                return collection.estimatedDocumentCount();
    return ratingRepository.count();
    }

    @Override
    public double avgRatings() {
   return ratingRepository.avg();


    }
}
