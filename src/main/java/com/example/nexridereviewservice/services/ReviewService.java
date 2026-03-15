package com.example.nexridereviewservice.services;

import com.example.nexridereviewservice.entity.Booking;
import com.example.nexridereviewservice.entity.Review;
import com.example.nexridereviewservice.repository.BookingRepository;
import com.example.nexridereviewservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository,BookingRepository bookingRepository){
        this.reviewRepository= reviewRepository;
        this.bookingRepository=bookingRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test service");

        Review r = Review.builder()
                .content("it is booking review")
                .rating(4.6).build();

        Booking b= Booking.builder()
                .startDate(new Date())
                .review(r)
                .totalDistance(7L)
                .build();

        bookingRepository.save(b);

        reviewRepository.save(r);

        List<Review> reviews = reviewRepository.findAll();
        for( Review r1 : reviews){
            System.out.println(r1.getContent());
        }
    }
}
