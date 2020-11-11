package com.example.demo.controllers;

import com.example.demo.ParamConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class WelcomeController {

    @Autowired
    ParamConfig paramConfig;

    @GetMapping("/test")
    public String methodOne() {
        return "Some Data " + paramConfig.paramstore;
    }
}
