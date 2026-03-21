package com.example.nexridereviewservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Driver extends BaseEntity{

    private String name;

    @Column(nullable = false,unique = true)
    private  String licenseNumber;

//    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "driver")
    List<Booking> bookings = new ArrayList<>();  // n : 1


}
