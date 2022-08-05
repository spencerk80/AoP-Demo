package com.github.spencerk.aspectDemo.context;

import com.github.spencerk.aspectDemo.Prompt.ListEmployeesPrompt;
import com.github.spencerk.aspectDemo.Prompt.MainMenuPrompt;
import com.github.spencerk.aspectDemo.Prompt.WelcomePrompt;
import com.github.spencerk.aspectDemo.dao.EmployeeDao;
import com.github.spencerk.aspectDemo.dao.EmployeeMemDao;
import com.github.spencerk.aspectDemo.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

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
        return new EmployeeMemDao();
    }

    /*********************************************************
     * Prompts
     *********************************************************/
    @Bean
    public WelcomePrompt getWelcomePrompt() {
        return new WelcomePrompt();
    }

    @Bean
    public MainMenuPrompt getMainMenuPrompt() {
        return new MainMenuPrompt();
    }

    @Bean
    public ListEmployeesPrompt getListEmployeePrompt() {
        return new ListEmployeesPrompt(getDao());
    }

    /*********************************************************
     * Misc
     *********************************************************/
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
