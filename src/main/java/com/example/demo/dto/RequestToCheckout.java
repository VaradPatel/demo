package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class RequestToCheckout {
    private final long user_id;
    private final long cart_id;
    private final String full_name;
    private final String address;
    private final long  pin_code;
    private final double amount;
    private final Boolean paid;
}
