package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request)
    {
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidRequest.class)
            public ResponseEntity<ErrorResponse>handleinvalidException(InvalidRequest ex, WebRequest request)
    {
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
