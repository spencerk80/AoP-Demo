package com.github.spencerk.aspectDemo.context;

import com.github.spencerk.aspectDemo.Prompt.WelcomePrompt;
import com.github.spencerk.aspectDemo.dao.EmployeeDao;
import com.github.spencerk.aspectDemo.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    /*********************************************************
     * Model
     *********************************************************/
    @Bean
    public Employee getEmployee() {
        return new Employee();
    }

    /*********************************************************
     * Dao
     *********************************************************/
    @Bean
    public EmployeeDao getDao() {
        return null;
    }

    /*********************************************************
     * Prompts
     *********************************************************/
    @Bean
    public WelcomePrompt getWelcomePrompt() {
        return new WelcomePrompt();
    }

}
