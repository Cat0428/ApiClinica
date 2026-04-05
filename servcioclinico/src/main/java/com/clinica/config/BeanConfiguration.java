package com.clinica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.clinica.domain.service.EvaluadorRangoService;

@Configuration
public class BeanConfiguration {

    @Bean
    public EvaluadorRangoService evaluadorRangoService() {
        return new EvaluadorRangoService();
    }
}