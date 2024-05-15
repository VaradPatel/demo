package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddProduct {
    private long id;
    private long productId;
    private String name;
    private long quantity;
    private double price ;
    private String imageName;
}
