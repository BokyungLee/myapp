package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        // Student student = new Student();
        // System.out.println(student.getStudentId());
        // System.out.println(student.getStudentName());
        // student.setStudentId("1");
        // student.setStudentName("이순신");

        // ApplicationContext context = 
        //     new ClassPathXmlApplicationContext("Beans.xml");
        // Student student = 
        //     context.getBean("student", Student.class);
        //     student.setStudentId("2");
        //     student.setStudentName("강감찬");
        //     System.out.println(student.getStudentName());

        // Address address = new Address();
        // address.setLocation("seoul");
        // Employee employee = new Employee();
        // employee.setName("세종대왕");
        // employee.setAddress(address);
        // employee.displayInfo();

        // ApplicationContext context = 
        //     new ClassPathXmlApplicationContext("Beans.xml");
        // Employee employee = 
        //     context.getBean("employee", Employee.class);
        //     employee.setName("홍길동 ");
        // Address address = 
        //     context.getBean("address", Address.class);
        //     address.setLocation("봉양");
        //     employee.setAddress(address);
        // employee.displayInfo();

        ApplicationContext context = 
            new AnnotationConfigApplicationContext(JavaConfig.class);
        Student student = 
            context.getBean("student", Student.class);
            student.setName("홍길동");
            System.out.println(student.getName());
        Address address = context.getBean(Address.class);
        address.setLocation("서울");
        Employee employee
            = context.getBean(Employee.class);
        System.out.println(employee.getAddress().getLocation());
        Department department = 
            context.getBean(Department.class);
            department.setName("개발팀");
        System.out.println(department.getName());
        employee.setName("을지문덕");
        Company company = context.getBean(Company.class);
        company.getEmployeeName();
    }
    
}

// interface Database {}
// class MySQL implements Database{}
// class Oracle implements Database{}