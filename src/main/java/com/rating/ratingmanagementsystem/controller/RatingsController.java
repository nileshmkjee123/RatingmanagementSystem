package com.rating.ratingmanagementsystem.controller;

import com.rating.ratingmanagementsystem.entity.Rating;
import com.rating.ratingmanagementsystem.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rating")
@AllArgsConstructor
public class RatingsController {

    private RatingService ratingService;

    @PostMapping("/submit")
    public Rating submitRating(@RequestBody Rating rating)
    {
        return ratingService.submitRating(rating);
    }

    @PutMapping("/update/{id}")
    public Rating updateRating(@PathVariable String id,
                               @RequestBody Rating rating)
    {
        return ratingService.updateRating(id,rating);
    }
//    @GetMapping("/get/{id}")
//    public Rating getRating(@PathVariable String id)
//    {
//        return ratingService.getRating(id);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteRating(@PathVariable String id)
    {
        return ratingService.deleteRating(id);
    }

    @GetMapping("/count")
    public long noOfRatings()
    {
        return ratingService.countRatings();
    }

    @GetMapping("/avg")
    public double averageRating()
    {
        return ratingService.avgRatings();
    }
}
