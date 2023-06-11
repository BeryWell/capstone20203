package com.example.skunk.controller;

import com.example.skunk.auth.AuthenticationRequest;
import com.example.skunk.auth.RegisterRequest;
import com.example.skunk.auth.jwt.JwtService;
import com.example.skunk.model.response.AuthenticationResponse;
import com.example.skunk.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "인증", description = "인증 관련 API")
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/get_claims")
    public String getClaims(HttpServletRequest request) {
        return jwtService.extractUsername(request.getHeader("Authorization"));
    }
}
