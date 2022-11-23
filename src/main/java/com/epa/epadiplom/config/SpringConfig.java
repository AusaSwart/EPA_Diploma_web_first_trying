package com.epa.epadiplom.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.epa.epadiplom.service", "com.epa.epadiplom.DAO"})
public class SpringConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgresql");
        dataSource.setPassword("123qwe");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/EPA?useSll=false");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

}
