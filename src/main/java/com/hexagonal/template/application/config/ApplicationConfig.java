package com.hexagonal.template.application.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.hexagonal.template")
@EntityScan(basePackages = "com.hexagonal.template")
@EnableJpaRepositories(basePackages = "com.hexagonal.template")
public class ApplicationConfig {
}
