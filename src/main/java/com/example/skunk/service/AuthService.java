package com.example.skunk.service;

import com.example.skunk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    // todo
    // 1. sign in
    // 2. sign up
}
