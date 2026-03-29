package com.example.nexridereviewservice.repository;

import com.example.nexridereviewservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);
    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("select r from Booking b inner join Review r  where b.id=:bookingId")
    Review findReviewByBookingID(Long bookingId);
}
