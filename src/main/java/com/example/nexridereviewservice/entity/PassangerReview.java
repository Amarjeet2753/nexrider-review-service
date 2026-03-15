package com.example.nexridereviewservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class PassangerReview extends Review{

    @Column(nullable = false)
    private String passangerReviewContent;

    @Column(nullable = false)
    private Double passangerRating;
}
