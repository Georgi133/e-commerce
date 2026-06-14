package com.example.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    public User findByEmail(String email);

}
