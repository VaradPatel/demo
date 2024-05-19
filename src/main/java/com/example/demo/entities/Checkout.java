package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Getter
@Setter
@Entity(name="checkout")

public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private final long userId;
    private final long cart_id;
    private final String full_name;
    private final String address;
    private final long  pin_code;
    private final double amount;
    private final Boolean paid;


}
