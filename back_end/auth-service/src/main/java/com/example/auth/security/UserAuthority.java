package com.example.auth.security;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

import com.example.auth.model.UserRole;

public class UserAuthority implements GrantedAuthority {

    private UserRole role;

    public UserAuthority(UserRole role) {
        setRole(role);
    }

    private void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    @Nullable
    public String getAuthority() {
        return this.role.name();
    }

    public UserRole getRole() {
        return this.role;
    }

}
