package com.example.demo.services;

import com.example.demo.dto.RequestAddToCard;
import com.example.demo.entities.Card;
import com.example.demo.entities.Products;
import com.example.demo.entities.User;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    UserRepository userRepository;
    @Async
    public void addToCart(RequestAddToCard requestAddToCard, Long userId)
    {
        System.out.println(requestAddToCard.getTotalQuantity());

   Card cart =cardRepository.findByUserId(userId);
   if(cart!=null)
        {
            List<Products>products=requestAddToCard.getItems();
          for(Products product: products)
          {
              product.setCartItem(cart);
          }

            cart.setProducts(requestAddToCard.getItems());
            ;
            cart.setTotalQuantity(requestAddToCard.getTotalQuantity());

            cardRepository.save(cart);
        }
   else {
       Card newCart=new Card();
       newCart.setTotalQuantity(requestAddToCard.getTotalQuantity());
       newCart.setProducts(requestAddToCard.getItems());
      User user=userRepository.findById(userId);

       newCart.setUser(user);
       cardRepository.save(newCart);
   }

    }
}
