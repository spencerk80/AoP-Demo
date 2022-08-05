package com.github.spencerk.aspectDemo.context;

import com.github.spencerk.aspectDemo.Prompt.*;
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
        return new ListEmployeesPrompt();
    }

    @Bean
    public AddEmployeePrompt getAddEmployeePrompt() {
        return new AddEmployeePrompt();
    }

    @Bean
    public EditEmployeePrompt getEditEmployeePrompt() {
        return new EditEmployeePrompt();
    }

    @Bean
    public DeleteEmployeePrompt getDeleteEmployeePrompt() {
        return new DeleteEmployeePrompt();
    }

    /*********************************************************
     * Misc
     *********************************************************/
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
