package com.github.spencerk.aspectDemo.prompt;

import com.github.spencerk.aspectDemo.context.AppContext;
import com.github.spencerk.aspectDemo.util.UserInput;
import org.springframework.stereotype.Component;

@Component
public class MainMenuPrompt implements Prompt {
    @Override
    public Prompt run() {
        char input;

        System.out.println(/*CLI formatting new line*/);
        input = UserInput.getChar(
                "What would you like to do?\n1: Show employee info\n2: Add an employee\n3: Edit an employee\n" +
                        "4: Delete an employee\n5: Quit",
                '1', '2', '3', '4', '5'
        );

        switch(input) {
            case '1':
                return (Prompt) AppContext.getContext().getBean("listEmployeesPrompt");
            case '2':
                return (Prompt) AppContext.getContext().getBean("addEmployeePrompt");
            case '3':
                return (Prompt) AppContext.getContext().getBean("editEmployeePrompt");
            case '4':
                return (Prompt) AppContext.getContext().getBean("deleteEmployeePrompt");
        }

        //Case 5 - quit
        return null;
    }
}
