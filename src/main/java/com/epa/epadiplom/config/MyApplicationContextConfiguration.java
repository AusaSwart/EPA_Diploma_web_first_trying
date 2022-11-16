package com.epa.epadiplom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MyApplicationContextConfiguration {
    @Bean
    @Scope("singleton")

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgresql");
        dataSource.setPassword("123qwe");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/EPA");
        return dataSource;
    }
}
