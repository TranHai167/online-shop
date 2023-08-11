package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

        String password = "16072002";
        String hashedPassword = passwordEncoder.encode(password);

        System.out.println("Original password: " + password);
        System.out.println("Hashed password: " + hashedPassword);
    }
}
