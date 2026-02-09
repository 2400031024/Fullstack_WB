package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Experiment5Application implements CommandLineRunner {

    private final Student student;

    public Experiment5Application(Student student){
        this.student = student;
    }

    public static void main(String[] args){
        SpringApplication.run(Experiment5Application.class,args);
    }

    public void run(String... args){
        student.display();
    }
}
