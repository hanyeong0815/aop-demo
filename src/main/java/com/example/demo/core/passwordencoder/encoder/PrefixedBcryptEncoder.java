package com.example.demo.core.passwordencoder.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class PrefixedBcryptEncoder extends BCryptPasswordEncoder {
    public PrefixedBcryptEncoder() {
        this(10);
    }

    public PrefixedBcryptEncoder(int strength) {
        super(strength);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String encoded = super.encode(rawPassword);

        if (!encoded.startsWith("{bcrypt}")) {
            encoded = "{bcrypt}" + encoded;
        }

        return encoded;
    }
}