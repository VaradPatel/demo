package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
private BigInteger productId;
private Long price;
private BigInteger quantity;
private BigInteger totalPrice;
private String name;
    @ManyToOne
    @JoinColumn(name = "cart_item_id")

    private Card cartItem;
}
