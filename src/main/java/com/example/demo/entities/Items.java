package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity(name="items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long productId;
    private String name;
    private long quantity;
    private double price ;
    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] image;
    private String imageName;

}
