package com.yuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Java26Springboot3Application {

    public static void main(String[] args) {
        SpringApplication.run(Java26Springboot3Application.class, args);
    }

}
