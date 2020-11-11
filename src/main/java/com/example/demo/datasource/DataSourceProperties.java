package com.example.demo.datasource;

import lombok.Data;

@Data
public class DataSourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
