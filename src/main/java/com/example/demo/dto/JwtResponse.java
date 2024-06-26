package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder

public class JwtResponse {
    private final String jwtToken;
    private final String email;
    private final Long id;
}
