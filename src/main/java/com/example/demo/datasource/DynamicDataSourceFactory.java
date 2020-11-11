package com.example.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;

public class DynamicDataSourceFactory {

    public static HikariDataSource buildDataSource(DataSourceProperties properties) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(properties.getDriverClassName());
        hikariDataSource.setJdbcUrl(properties.getUrl());
        hikariDataSource.setUsername(properties.getUsername());
        hikariDataSource.setPassword(properties.getPassword());

        return hikariDataSource;
    }
}
