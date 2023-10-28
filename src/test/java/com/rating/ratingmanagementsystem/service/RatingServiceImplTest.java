package com.rating.ratingmanagementsystem.service;

import com.rating.ratingmanagementsystem.entity.Rating;
import com.rating.ratingmanagementsystem.repo.RatingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class RatingServiceImplTest {

    @Mock
    private RatingRepository ratingRepository;
    private RatingService ratingService;
    AutoCloseable autoCloseable;
    Rating rating;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        ratingService = new RatingServiceImpl(ratingRepository);
        rating = new Rating();
        rating.setRating(5.0);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testSubmitRating() {
        mock(Rating.class);
        mock(RatingRepository.class);

        when(ratingRepository.save(rating)).thenReturn(rating);
        assertThat(ratingService.submitRating(rating)).
                isEqualTo(rating);

    }
//
//    @Test
//    void testUpdateRating() {
//        mock(Rating.class);
//        mock(RatingRepository.class);
//
//        Rating rating1 = new Rating(4.0);
//
//        //toUpdateRating.setRating(rating.getRating());
//        //ratingRepository.save(toUpdateRating);
//        //when(ratingRepository.findById(rating.getId()).get()).thenReturn(rating);
//        System.out.println(rating1.getId());
////        assertThat(ratingService.updateRating(rating1.getId(),rating1)).
////                isEqualTo(rating1);
//    }
//
    @Test
    void testDeleteRating() {
        mock(Rating.class);
        mock(RatingRepository.class, Mockito.CALLS_REAL_METHODS);
        doAnswer(Answers.CALLS_REAL_METHODS).when(
                ratingRepository).deleteById(any());
        assertThat(ratingService.deleteRating("653aaf5819c4077c9fda64b0")).
                isEqualTo("Rating for "+"653aaf5819c4077c9fda64b0"
                        +" is removed");

    }
//
    @Test
    void countRatings() {

        mock(Rating.class);
        mock(RatingRepository.class);

        Rating rating1 = new Rating();
        rating1.setRating(4.0);
        Rating rating2 = new Rating();
        rating2.setRating(1.0);
        when(ratingRepository.count()).thenReturn(3L);
        assertThat(ratingService.countRatings()).
                isEqualTo(3L);
    }

    @Test
    void avgRatings() {
        mock(Rating.class);
        mock(RatingRepository.class);

        Rating rating1 = new Rating();
        rating1.setRating(4.0);
        Rating rating2 = new Rating();
        rating2.setRating(3.0);
        when(ratingRepository.avg()).thenReturn(4.0);
        assertThat(ratingService.avgRatings()).
                isEqualTo(4.0);
    }
}