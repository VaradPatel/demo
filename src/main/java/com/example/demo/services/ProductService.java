package com.example.demo.services;

import com.example.demo.dto.AddProduct;
import com.example.demo.entities.Items;
import com.example.demo.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ItemsRepository itemsRepository;
    public List<Items> getAllProducts()
    {
        List<Items>allproducts=itemsRepository.findAll();
        return allproducts;
    }
    public Items getProductById(Long id)
    {
        Items item=itemsRepository.findByProductId(id);
        return item;
    }
    public void addProduct(AddProduct addProduct, MultipartFile image) throws RuntimeException, IOException {
        if(image!=null || image.getBytes()==null)
        {
            throw new RuntimeException();
        }

    }
}
