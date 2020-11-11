package com.example.demo.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TenantAwareRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicContextHolder.get();
    }

    @Override
    protected DataSource determineTargetDataSource() {
        try {
            DataSource ds =  getDataSource();
            Map<Object, Object> targetDataSources = new HashMap<>();
            targetDataSources.put("default", ds);
            this.setDefaultTargetDataSource(targetDataSources);
            return ds;
        } catch (SQLException e) {
            return null;
        }
    }

    public DataSource getDataSource() throws SQLException {

        Object key = determineCurrentLookupKey();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("");
        dataSource.setUrl("jdbc:mysql://multitenant.cnomnpfh6euf.ap-south-1.rds.amazonaws.com:3306/tenantone");
        dataSource.setUsername("admin");
        dataSource.setPassword("simurg8");

        System.out.println("## DataSource: " + dataSource.toString());

        return dataSource;
    }
}
