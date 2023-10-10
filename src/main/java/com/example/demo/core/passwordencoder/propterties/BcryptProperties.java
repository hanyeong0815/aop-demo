package com.example.demo.core.passwordencoder.propterties;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@ConfigurationPropertiesBinding
public record BcryptProperties(
        Integer costFactor
) {
    public BcryptProperties {
        if (costFactor == null) costFactor = 10;
    }
}
