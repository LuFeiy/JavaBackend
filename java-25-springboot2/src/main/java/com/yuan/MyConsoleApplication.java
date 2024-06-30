package com.yuan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 在这里执行你的命令行逻辑
        System.out.println("Hello, World!");
        for (String arg : args) {
            System.out.println("Received argument: " + arg);
        }
    }
}
