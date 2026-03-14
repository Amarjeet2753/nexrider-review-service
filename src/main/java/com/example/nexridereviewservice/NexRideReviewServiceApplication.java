package com.example.nexridereviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NexRideReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexRideReviewServiceApplication.class, args);
    }

}
