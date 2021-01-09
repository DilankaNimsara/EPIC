package com.dilanka_a.assignment.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dilanka_a
 */

@Configuration
public class webConfig {

    /**
     * create modle mapper object
     *
     * @return modelMapper
     */
    @Bean
    public ModelMapper ModelMapper() {
        return new ModelMapper();
    }

}
