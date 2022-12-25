package com.udemyapi.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();

    }
}
