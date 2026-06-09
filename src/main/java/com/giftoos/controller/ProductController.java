package com.giftoos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.giftoos.model.Product;
import com.giftoos.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @GetMapping("/latest")
    public List<Product> getLatestProducts() {
        List<Product> all = repo.findAll();
        return all.size() > 4 ? all.subList(0, 4) : all;
    }
    
}
