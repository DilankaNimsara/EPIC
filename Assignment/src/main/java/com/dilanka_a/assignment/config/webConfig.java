package com.dilanka_a.assignment.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class webConfig {

    @Bean
    public ModelMapper ModelMapper() {
        return new ModelMapper();
    }

}
