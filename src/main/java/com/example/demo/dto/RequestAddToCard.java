package com.example.demo.dto;

import com.example.demo.entities.Products;
import com.example.demo.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@ToString

public class RequestAddToCard {






    private List<Products> items;

    private BigInteger totalQuantity;
}
