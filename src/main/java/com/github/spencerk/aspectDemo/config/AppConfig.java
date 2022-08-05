package com.github.spencerk.aspectDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "com.github.spencerk.aspectDemo")
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
