package com.example.demo.Exception;

import lombok.*;

import java.time.LocalDateTime;
@Data@AllArgsConstructor@NoArgsConstructor @Getter
@Setter
public class ErrorResponse {
    private String message;
    private String details;
    private LocalDateTime timestamp;

}
