package com.github.spencerk.aspectDemo.prompt;

import com.github.spencerk.aspectDemo.context.AppContext;
import com.github.spencerk.aspectDemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListEmployeesPrompt implements Prompt {
    @Autowired
    private EmployeeDao     dao;


    @Override
    public Prompt run() {

        dao.getAll().forEach(System.out::println);

        return (Prompt) AppContext.getContext().getBean("mainMenuPrompt");
    }
}
