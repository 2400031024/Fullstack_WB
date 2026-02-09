package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Certification {

    @Value("C101")
    private String id;

    @Value("Java Full Stack")
    private String name;

    @Value("2025")
    private String dateOfCompletion;

    @Override
    public String toString() {
        return id+" "+name+" "+dateOfCompletion;
    }
}

