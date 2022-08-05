package com.github.spencerk.aspectDemo.Prompt;

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
                return AppContext.getContext().getBean(ListEmployeesPrompt.class);
            case '2':
                return AppContext.getContext().getBean(AddEmployeePrompt.class);
            case '3':
                return null;
            case '4':
                return null;
        }

        //Case 5 - quit
        return null;
    }
}
