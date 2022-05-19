package com.example.homekiri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HomekiriApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomekiriApplication.class, args);
    }

}
