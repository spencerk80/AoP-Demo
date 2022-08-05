package com.github.spencerk.aspectDemo.prompt;

import com.github.spencerk.aspectDemo.context.AppContext;
import com.github.spencerk.aspectDemo.dao.EmployeeDao;
import com.github.spencerk.aspectDemo.exception.NonUniqueIdException;
import com.github.spencerk.aspectDemo.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteEmployeePrompt implements Prompt {
    @Autowired
    private EmployeeDao dao;

    @Override
    public Prompt run() {
        String id = UserInput.getString("Enter id of the employee to be deleted.");

        try {
            dao.deleteEmployee(id);
        } catch(NonUniqueIdException e) {
            System.err.println(e.getMessage());
        }

        return (Prompt) AppContext.getContext().getBean("mainMenuPrompt");
    }
}
