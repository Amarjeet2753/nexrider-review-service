package com.example.nexridereviewservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passanger extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "passanger")
    List<Booking> bookings = new ArrayList<>();  // n : 1
}
