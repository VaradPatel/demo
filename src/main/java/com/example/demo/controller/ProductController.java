package com.example.demo.controller;

import com.example.demo.dto.AddProduct;
import com.example.demo.entities.Items;
import com.example.demo.repository.ItemsRepository;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController  {

    @Autowired
    ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Items>>allProducts() throws RuntimeException
    {
        try {
            List<Items>allproducts=productService.getAllProducts();
            return ResponseEntity.ok(allproducts);
        }
        catch(Exception e)
        {
            throw new Error(e);
        }
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<?>getproduct(@PathVariable Long id) throws RuntimeException
    {
        try{
            Items item=productService.getProductById(id);
            if(item!=null)
            return ResponseEntity.ok(item);
            else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        catch(Exception e)
        {
            throw new Error(e);
        }

    }
    @PostMapping("/addproduct")
    public void addProduct(@RequestParam(value="image",required = false)MultipartFile image, @RequestPart AddProduct addProduct) throws RuntimeException
    {
        try
        {


        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }



}
