package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    // Constructor Injection
    public Student(
            @Value("101") int studentId,
            @Value("Hasmita") String name) {

        this.studentId = studentId;
        this.name = name;
    }

    // Setter Injection
    @Value("CSE")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("2")
    public void setYear(int year) {
        this.year = year;
    }

    public void display() {
        System.out.println(studentId+" "+name+" "+course+" "+year);
    }
}

