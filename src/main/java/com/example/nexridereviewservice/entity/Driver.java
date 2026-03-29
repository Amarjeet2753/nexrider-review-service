package com.example.nexridereviewservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    private String phoneNumber;

    @Column(nullable = false,unique = true)
    private  String licenseNumber;

//    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "driver")
     @Fetch(FetchMode.SUBSELECT)
    List<Booking> bookings = new ArrayList<>();  // n : 1


}
