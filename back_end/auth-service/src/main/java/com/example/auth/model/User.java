package com.example.auth.model;

import org.hibernate.annotations.UuidGenerator;

import com.example.auth.dto.SignUpRequestDto;
import com.example.auth.validation.ValidPassword;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
@Entity(name = "users")
@AllArgsConstructor
public class User {

    @UuidGenerator //tells hibernate how to the generation strategy of uuid field should be
    @GeneratedValue(strategy = GenerationType.UUID)//tells hibernate that it will be generated automatically (in this case by the @UuidGenerator)
    @Id
    @Column(nullable = false, updatable = false, length = 36)
    private String uuid;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    public static User from(SignUpRequestDto signUpRequest, String encodedPassword) {
        User user = new User();
        user.setFirstName(signUpRequest.firstName());
        user.setLastName(signUpRequest.lastName());
        user.setEmail(signUpRequest.email());
        user.setPassword(encodedPassword);
        return user;
    }

}
