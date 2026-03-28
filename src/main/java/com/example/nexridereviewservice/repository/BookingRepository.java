package com.example.nexridereviewservice.repository;

import com.example.nexridereviewservice.entity.Booking;
import com.example.nexridereviewservice.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findAllByDriverIn(List<Driver> drivers);
}
