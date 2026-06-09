package com.giftoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.giftoos.model.User;
import com.giftoos.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        repo.save(user);
        return "User Registered Successfully";
    }


    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User dbUser = repo.findByEmail(user.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (encoder.matches(user.getPassword(), dbUser.getPassword())) {
            dbUser.setPassword(null); 
            return dbUser;            
        }

        throw new RuntimeException("Invalid credentials");
    }
}