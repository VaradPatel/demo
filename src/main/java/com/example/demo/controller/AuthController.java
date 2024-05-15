package com.example.demo.controller;

import com.example.demo.dto.JwtRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtHelper;
import com.example.demo.services.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;
    @Autowired
    private userService service;
    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) throws RuntimeException{

        this.doAuthenticate(request.getEmail(), request.getPassword());

System.out.println("here");

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
       Optional<User> user=userRepository.findUserByEmail(request.getEmail());
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .email(user.get().getEmail())
                .id(user.get().getId()).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/createuser")
    public ResponseEntity<com.example.demo.entities.User> createUser(@RequestBody com.example.demo.entities.User user)
    {
        try
        {
            service.createUser(user);

return ResponseEntity.ok(user);
        }
        catch(Exception e)
        {
            return ResponseEntity.internalServerError().body(null);

        }
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
