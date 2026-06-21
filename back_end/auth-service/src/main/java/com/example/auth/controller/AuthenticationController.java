package com.example.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.dto.SignInRequestDto;
import com.example.auth.dto.SignUpRequestDto;
import com.example.auth.service.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequestDto signUpRequest) {
        authenticationService.register(signUpRequest);
        return ResponseEntity.created(null).body("Success");
    }

    @PostMapping("/login")
    public ResponseEntity<String> signIn(@Valid @RequestBody SignInRequestDto signInRequest) {
        String token = authenticationService.login(signInRequest);
        return ResponseEntity.ok().body(token);
    }


}