package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.test")
public class JavaConfig {

    @Bean
    public Student student() {
        return new Student();
    }
    @Bean
    public Employee employee() {
        Employee employee = new Employee();
        employee.setAddress(address());
        return employee;
    }
    @Bean
    public Address address() {
        return new Address();
    }

}