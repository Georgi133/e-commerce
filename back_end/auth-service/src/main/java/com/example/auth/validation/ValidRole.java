package com.example.auth.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Documented;

@Documented
@Target(FIELD)
@Constraint(validatedBy = RoleConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRole {
    String message () default "Invalid role";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
