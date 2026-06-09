package com.giftoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.giftoos.model.Order;
import com.giftoos.repository.OrderRepository;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        repo.save(order);
        return "Order placed successfully";
    }
}
