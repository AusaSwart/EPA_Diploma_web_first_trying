package com.epa.epadiplom.config;

import com.epa.epadiplom.service.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    @Bean
    public TestBean getTestBean(){
        return new TestBean("Hello");
    }
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgresql");
        dataSource.setPassword("123qwe");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/EPA");
        return dataSource;
    }

}
