package com.app.controllers;

import com.app.dto.UserLoginDto;
import com.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDto loginDto) {
        boolean isAuthenticated = authService.login(loginDto);

        if (isAuthenticated) {
            // In a real application, generate a JWT token here and return it
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
