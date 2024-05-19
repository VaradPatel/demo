package com.example.demo.repository;

import com.example.demo.entities.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout,Long> {
   Checkout findByUserId(long user_id);
}
