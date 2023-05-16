package com.example.skunk.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ApiError {
    private String path;
    private String message;
    private int statusCode;
}
