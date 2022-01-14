package com.example.notdemo.domain.inner;

import org.springframework.security.core.GrantedAuthority;

import java.util.Locale;

public enum UserRole implements GrantedAuthority {
    ADMIN,

    CUSTOMER,

    RETAILER;

    @Override
    public String getAuthority() {
        return name().toUpperCase();
    }
}
