package com.example.auth.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.auth.model.User;
import com.example.auth.model.UserRole;
import com.example.auth.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StartupRunner implements CommandLineRunner {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.email}")
    private String adminEmail;
    @Value("${admin.password}")
    private String adminPassword;
    @Value("${admin.firstName}")
    private String adminFirstName;
    @Value("${admin.lastName}")
    private String adminLastName;


    public StartupRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<User> adminUser = userRepository.findByEmail(adminEmail);
        if(adminUser.isPresent()) {
            log.info("Admin user already exists.");
            return;
        }

        validateAdminParams(adminEmail, adminPassword, adminFirstName, adminLastName);
        User admin = new User();
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setFirstName(adminFirstName);
        admin.setLastName(adminLastName);
        admin.setRole(UserRole.ADMIN.name());
        userRepository.save(admin);
        log.info("Admin user created successfully.");
    }

    private void validateAdminParams(String ... args) {
        for(String arg : args) {
            if(arg == null || arg.isEmpty()) {
                throw new RuntimeException("Arguments of admin cannot be null or empty");
            }
        }
    }

}
