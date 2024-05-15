package com.example.demo.dto;

import com.example.demo.entities.Products;
import lombok.*;

import java.math.BigInteger;
import java.util.List;
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ResponseGetCart {
    private List<ProductResponse> products;

    private BigInteger totalQuantity;
}
