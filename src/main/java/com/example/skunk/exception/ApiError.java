package com.example.skunk.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiError {
    private String path;
    private String message;
    private int statusCode;
}
