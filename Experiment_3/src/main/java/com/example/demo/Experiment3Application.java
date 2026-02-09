package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Experiment3Application implements CommandLineRunner {

    @Autowired
    ProductRepo repo;

    public static void main(String[] args){
        SpringApplication.run(Experiment3Application.class,args);
    }

    public void run(String... args){

        repo.save(new Product("Laptop","Electronics",80000,5));
        repo.save(new Product("Phone","Electronics",30000,10));
        repo.save(new Product("Mouse","Accessory",500,50));

        System.out.println(repo.priceAsc());
        System.out.println(repo.priceDesc());
        System.out.println("Total:"+repo.total());
    }
}
