package com.rating.ratingmanagementsystem.entity;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Rating {
    @Transient
    public static final String SEQUENCE_NAME = "ratings_sequence";
    @Id
    private Long ratingId;
    @NotEmpty
    @DecimalMax("5.0")
    @DecimalMin("0.0")
    private double rating;
}
