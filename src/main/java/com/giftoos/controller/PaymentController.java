package com.giftoos.controller;

import com.giftoos.config.RazorpayConfig;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private RazorpayConfig razorpayConfig;

    
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    // Create Order
    @PostMapping("/create-order")
    public String createOrder(@RequestBody Map<String, Object> data) throws Exception {

        int amount = (int) data.get("amount");

        RazorpayClient client = razorpayConfig.razorpayClient();

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "receipt_" + System.currentTimeMillis());

        Order order = client.orders.create(orderRequest);
        return order.toString();
    }

    //API
    @GetMapping("/razorpay-key")
    public Map<String, String> getRazorpayKey() {
        Map<String, String> response = new HashMap<>();
        response.put("key", razorpayKeyId); 
        return response;
    }
}
