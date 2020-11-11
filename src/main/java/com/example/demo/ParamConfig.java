package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParamConfig {

    @Value("${propertyname}")
    public String paramstore;


}
