package com.example.demo.repository;

import com.example.demo.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items,Long> {


    Items findByProductId(Long id);

}
