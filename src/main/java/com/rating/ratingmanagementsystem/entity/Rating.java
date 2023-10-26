package com.rating.ratingmanagementsystem.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "ratings")
@Data
public class Rating {
//    @Transient
//    public static final String SEQUENCE_NAME = "ratings_sequence";
    @Id
    private String id;
    @NotEmpty
    @NotNull
    private double rating;
}
