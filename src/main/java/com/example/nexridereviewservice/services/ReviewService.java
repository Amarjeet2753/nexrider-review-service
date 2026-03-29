package com.example.nexridereviewservice.services;

import com.example.nexridereviewservice.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReview();

    public Boolean deleteReviewById(Long id);

}
