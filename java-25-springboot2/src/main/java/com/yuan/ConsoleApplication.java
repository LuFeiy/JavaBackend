package com.yuan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ConsoleApplication {

    public static void main(String[] args) {
        System.out.println("before");
        SpringApplication.run(ConsoleApplication.class, args);
        System.out.println("after");
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            // 在这里写下你的逻辑
            System.out.println("Hello, this is a non-web application running with Spring Boot!");
        };
    }
}
