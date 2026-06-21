package com.example.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auth.dto.SignInRequestDto;
import com.example.auth.dto.SignUpRequestDto;
import com.example.auth.exception.InvalidUserInputException;
import com.example.auth.model.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.util.JwtUtil;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String register(SignUpRequestDto signUpRequest) {
        if(userRepository.findByEmail(signUpRequest.email()).isPresent()) {
            throw new InvalidUserInputException("The email is already in use!");
        }
        User user = User.from(signUpRequest, passwordEncoder.encode(signUpRequest.password()));
        return userRepository.save(user).getUuid();
    }

    public String login(SignInRequestDto signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(signInRequest.email(), signInRequest.password())
        );
        final UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    public String getUserEmailFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated");
        }
        return authentication.getName();
    }
    
}
