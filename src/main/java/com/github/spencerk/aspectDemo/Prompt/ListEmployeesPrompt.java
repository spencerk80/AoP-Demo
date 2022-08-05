package com.github.spencerk.aspectDemo.Prompt;

import com.github.spencerk.aspectDemo.context.AppContext;
import com.github.spencerk.aspectDemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListEmployeesPrompt implements Prompt {

    private EmployeeDao     dao;

    @Autowired
    public ListEmployeesPrompt(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public Prompt run() {

        dao.getAll().forEach(System.out::println);

        return AppContext.getContext().getBean(MainMenuPrompt.class);
    }
}
