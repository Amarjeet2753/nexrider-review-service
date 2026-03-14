package com.example.nexridereviewservice.services;

import com.example.nexridereviewservice.entity.Review;
import com.example.nexridereviewservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository= reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test service");

        Review r = Review.builder()
                .content("it was good")
                .rating(4.6).build();

        reviewRepository.save(r);

        List<Review> reviews = reviewRepository.findAll();
        for( Review r1 : reviews){
            System.out.println(r1.getContent());
        }
    }
}
