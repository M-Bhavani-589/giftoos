package com.giftoos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giftoos.model.ContactMessage;

public interface ContactRepository extends JpaRepository<ContactMessage, Long> {
}