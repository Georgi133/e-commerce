package com.example.auth.validation;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;

        List<String> violations = new ArrayList<>();

        if (!password.matches(".*[A-Z].*"))       violations.add("one uppercase letter");
        if (!password.matches(".*[a-z].*"))       violations.add("one lowercase letter");
        if (!password.matches(".*\\d.*"))         violations.add("one number");
        if (!password.matches(".*[!@#$%^&*].*"))  violations.add("one special character (!@#$%^&*)");

        if (violations.isEmpty()) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
            "Password must contain at least: " + String.join(", ", violations)
        ).addConstraintViolation();

        return false;
    }

}
