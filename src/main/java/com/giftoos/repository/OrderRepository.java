package com.giftoos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.giftoos.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}