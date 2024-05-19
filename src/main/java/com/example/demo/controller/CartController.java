package com.example.demo.controller;

import com.example.demo.dto.ProductResponse;
import com.example.demo.dto.RequestAddToCard;
import com.example.demo.dto.ResponseAddToCart;
import com.example.demo.dto.ResponseGetCart;
import com.example.demo.entities.Card;
import com.example.demo.entities.Products;
import com.example.demo.repository.CardRepository;
import com.example.demo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@CrossOrigin
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    CardRepository cardRepository;

    @PostMapping("/addtocart/{id}")
    ResponseEntity<ResponseAddToCart> addToCart(@RequestBody RequestAddToCard requestAddToCard , @PathVariable Long id) throws RuntimeException {

        try {
            cartService.addToCart(requestAddToCard, id);
            ResponseAddToCart responseAddToCart = new ResponseAddToCart("added TO Cart");
            return ResponseEntity.ok(responseAddToCart);
        } catch (Exception Error) {

            throw new RuntimeException(Error);

        }
    }
@GetMapping("/getcart/{id}")
        ResponseEntity<ResponseGetCart>getCart(@PathVariable Long id) throws RuntimeException
{
    System.out.println("in get cart");
       try {

                Card card = cardRepository.findByUserId(id);



                ResponseGetCart responseGetCart=new ResponseGetCart();
                if(card==null)
                {
                    return ResponseEntity.ok(responseGetCart);
                }
           List<ProductResponse>productResponseList=new ArrayList<>();
//                responseGetCart.setProducts(card.getProducts());

               responseGetCart.setTotalQuantity(card.getTotalQuantity());

                for(Products product:card.getProducts())
                {
                    ProductResponse productResponse=new ProductResponse();
                    productResponse.setId(product.getId());
                    productResponse.setName(product.getName());
                    productResponse.setProductId(product.getProductId());
                    productResponse.setPrice(product.getPrice());
                    productResponse.setQuantity(product.getQuantity());
                    productResponse.setTotalPrice(product.getTotalPrice());
                    productResponseList.add(productResponse);

                }
                responseGetCart.setProducts(productResponseList);

return ResponseEntity.ok(responseGetCart);
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }
        }

}
