package com.example.demo.core.redis.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import static com.example.demo.common.support.ServerConstants.BASE_PACKAGE;

@Configuration
@RequiredArgsConstructor
@ConfigurationPropertiesScan(basePackageClasses = RedisProperties.class)
@EnableRedisRepositories(basePackages = BASE_PACKAGE)
public class RedisConfig {
    private final RedisProperties redisProperties;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(@Value("${spring.profiles.active}") String activeProfile) {
        RedisConfiguration redisConfiguration;

        redisConfiguration = new RedisStandaloneConfiguration(
                redisProperties.getHost(),
                redisProperties.getPort()
        );

        return new LettuceConnectionFactory(redisConfiguration);
    }
}
