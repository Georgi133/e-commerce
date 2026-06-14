package com.example.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.dto.SignInRequestDto;
import com.example.auth.dto.SignUpRequestDto;
import com.example.auth.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto signUpRequest) {
        authenticationService.register(signUpRequest);
        return ResponseEntity.created(null).body("Success");
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody SignInRequestDto signInRequest) {
        authenticationService.login(signInRequest);
        return ResponseEntity.ok().build();
    }


}