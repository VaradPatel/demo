package com.example.demo.controller;

import com.example.demo.Exception.InvalidRequest;
import com.example.demo.dto.RequestToCheckout;
import com.example.demo.entities.Checkout;
import com.example.demo.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
@CrossOrigin

public class CheckoutController {
    @Autowired
    CheckoutRepository checkoutRepository;

    @PostMapping("/{userid}")
    public ResponseEntity<?>checkout(@PathVariable long userid, @RequestBody RequestToCheckout requestToCheckout)
    {
        try {
          Checkout checkout = checkoutRepository.findByUserId(userid);


            if (checkout != null)
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");

            else {

            Checkout add= Checkout.builder().
                    address(requestToCheckout.getAddress()).
                    full_name(requestToCheckout.getFull_name()).
                    paid(requestToCheckout.getPaid()).
                    pin_code(requestToCheckout.getPin_code()).
                    cart_id(requestToCheckout.getCart_id()).amount(requestToCheckout.getAmount()).cart_id(requestToCheckout.getCart_id()).userId(userid).

                    build();
             checkoutRepository.save(add);

               return ResponseEntity.ok("succesfully added");
            }
        }
        catch(Exception e)
        {
         throw new InvalidRequest("userid is invalid");
        }
    }

}
