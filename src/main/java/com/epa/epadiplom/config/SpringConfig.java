package com.epa.epadiplom.config;

import com.epa.epadiplom.service.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public TestBean getTestBean(){
        return new TestBean("Hello");
    }
}
