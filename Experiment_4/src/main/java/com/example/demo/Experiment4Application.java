package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Experiment4Application implements CommandLineRunner {

    private final Student student;

    public Experiment4Application(Student student){
        this.student = student;
    }

    public static void main(String[] args){
        SpringApplication.run(Experiment4Application.class,args);
    }

    public void run(String... args){
        student.display();
    }
}
