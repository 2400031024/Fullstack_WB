package com.klu.service;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product addProduct(Product product){
        return repository.save(product);
    }

    public List<Product> getProductsByCategory(String category){
        return repository.findByCategory(category);
    }

    public List<Product> getProductsByRange(double min,double max){
        return repository.findByPriceBetween(min,max);
    }

    public List<Product> getSortedProducts(){
        return repository.getProductsSortedByPrice();
    }

    public List<Product> getExpensiveProducts(double price){
        return repository.getExpensiveProducts(price);
    }

}