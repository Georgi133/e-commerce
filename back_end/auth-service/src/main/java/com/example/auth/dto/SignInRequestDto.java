package com.example.auth.dto;

import com.example.auth.validation.ValidPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignInRequestDto(

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email, 
    
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    @ValidPassword
    String password
) {
    
}
