package com.example.nexridereviewservice.services;

import com.example.nexridereviewservice.entity.Booking;
import com.example.nexridereviewservice.entity.Driver;
import com.example.nexridereviewservice.repository.BookingRepository;
import com.example.nexridereviewservice.repository.DriverRepository;
import com.example.nexridereviewservice.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;
    @Autowired
    private DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository,BookingRepository bookingRepository){
        this.reviewRepository= reviewRepository;
        this.bookingRepository=bookingRepository;

    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("test service");
//
//        Review r = Review.builder()
//                .content("it is booking review")
//                .rating(4.6).build();
//
//        Booking b= Booking.builder()
//                .startDate(new Date())
//                .review(r)
//                .totalDistance(7L)
//                .build();
//
//        bookingRepository.save(b);
//
//        reviewRepository.save(r);
//
//        List<Review> reviews = reviewRepository.findAll();
//        for( Review r1 : reviews){
//            System.out.println(r1.getContent());
//        }

//        Optional<Driver> d = driverRepository.findByIdAndLicenseNumber(1L,"D1232131");
//        if(d.isPresent()){
//            System.out.println(d.get().getName());
//        }
//        Optional<Driver> d = driverRepository.rawQueryfindByIdAndLicenseNumber(1L,"D1232131");
//        if(d.isPresent()){
//            System.out.println(d.get().getName());
//        }
//        Optional<Driver> d = driverRepository.hqlFindByIdAndLicenseNumber(1L,"D1232131");
//        if(d.isPresent()){
//            System.out.println(d.get().getName());
//        }

        List<Long> driverIds= new ArrayList<>(Arrays.asList(1L,2L));

        List<Driver>  drivers= driverRepository.findAllByIdIn(driverIds);
//        List<Booking> bookings= bookingRepository.findAllByDriverIn(drivers);

        for(Driver driver : drivers){
            List<Booking> b1 = driver.getBookings();
            b1.forEach(booking -> System.out.println(booking.getId()));

        }
    }

}
