package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(){}

    public Product(String name,String d,double p,int q){
        this.name=name;
        this.description=d;
        this.price=p;
        this.quantity=q;
    }

    public String toString(){
        return name+" | "+price+" | "+quantity;
    }
}
