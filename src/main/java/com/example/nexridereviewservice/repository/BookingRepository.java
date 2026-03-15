package com.example.nexridereviewservice.repository;

import com.example.nexridereviewservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
