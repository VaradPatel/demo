package com.example.demo.repository;

import com.example.demo.entities.Card;
import com.example.demo.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByUserId(Long aLong);


    void save(Optional<Card> card);
}
