package com.example.demo.Exception;

public class InvalidRequest extends RuntimeException{
    public InvalidRequest(String message)
    {
        super(message);
    }
}
