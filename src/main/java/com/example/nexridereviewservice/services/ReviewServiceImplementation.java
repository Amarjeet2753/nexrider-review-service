package com.example.nexridereviewservice.services;

import com.example.nexridereviewservice.entity.Review;
import com.example.nexridereviewservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService{

    private ReviewRepository reviewRepository;

    public  ReviewServiceImplementation(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Boolean deleteReviewById(Long id) {
        try {
            reviewRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
