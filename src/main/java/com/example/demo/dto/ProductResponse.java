package com.example.demo.dto;

import lombok.*;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {
    private Long id;
    private BigInteger productId;
    private Long price;
    private BigInteger quantity;
    private BigInteger totalPrice;
    private String name;
}
