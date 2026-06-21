package com.example.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/v1/test")
@Slf4j
public class TestController {

    private AuthenticationService authenticationService;

    public TestController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @GetMapping
    public ResponseEntity<String> test() {
        String email = authenticationService.getUserEmailFromRequest();
        log.info("Testing with user email: {}", email);
        return ResponseEntity.ok("Test successful");
    }


    
}
