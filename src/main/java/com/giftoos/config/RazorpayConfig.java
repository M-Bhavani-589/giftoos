package com.giftoos.config;

import com.razorpay.RazorpayClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RazorpayConfig {

    @Value("${razorpay.key.id}")
    private String keyId;

    @Value("${razorpay.key.secret}")
    private String keySecret;

    public RazorpayClient razorpayClient() throws Exception {
        return new RazorpayClient(keyId, keySecret);
    }
}
