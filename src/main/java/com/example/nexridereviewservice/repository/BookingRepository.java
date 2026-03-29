package com.example.nexridereviewservice.repository;

import com.example.nexridereviewservice.entity.Booking;
import com.example.nexridereviewservice.entity.Driver;
import com.example.nexridereviewservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findAllByDriverIn(List<Driver> drivers);


}
