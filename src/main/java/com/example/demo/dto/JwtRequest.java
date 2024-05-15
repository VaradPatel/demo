package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@ToString
public class JwtRequest {
    private final String email;
    private final String password;
}
