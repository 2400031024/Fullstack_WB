package com.klu.controller;

import com.klu.entity.Product;
import com.klu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    // Insert product
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return service.getProductsByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> filterByPrice(@RequestParam double min, @RequestParam double max){
        return service.getProductsByRange(min,max);
    }

    // Sorted products
    @GetMapping("/sorted")
    public List<Product> sortedProducts(){
        return service.getSortedProducts();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price){
        return service.getExpensiveProducts(price);
    }
}