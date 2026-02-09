package com.example.demo;

import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long>{

    @Query("FROM Product ORDER BY price ASC")
    List<Product> priceAsc();

    @Query("FROM Product ORDER BY price DESC")
    List<Product> priceDesc();

    @Query("SELECT COUNT(p) FROM Product p")
    long total();
}

