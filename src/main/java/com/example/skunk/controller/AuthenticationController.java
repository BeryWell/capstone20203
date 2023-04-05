package com.example.skunk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class AuthenticationController {
    @PostMapping("/signup")
    public ResponseEntity signup(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.ok("test success!");
    }
}
