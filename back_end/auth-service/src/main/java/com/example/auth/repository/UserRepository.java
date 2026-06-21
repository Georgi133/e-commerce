package com.example.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    public Optional<User> findByEmail(String email);

}
