package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("1")
    private int id;

    @Value("Hasmita")
    private String name;

    @Value("Female")
    private String gender;

    @Autowired
    private Certification certification;

    public void display() {
        System.out.println(id+" "+name+" "+gender);
        System.out.println("Certification: "+certification);
    }
}

