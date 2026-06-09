package com.giftoos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.giftoos.model.ContactMessage;
import com.giftoos.repository.ContactRepository;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

    @Autowired
    private ContactRepository repo;

    @PostMapping
    public String saveMessage(@RequestBody ContactMessage msg) {
        repo.save(msg);
        return "Message Sent Successfully";
    }
}
