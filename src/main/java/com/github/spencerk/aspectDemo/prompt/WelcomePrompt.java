package com.github.spencerk.aspectDemo.prompt;

import com.github.spencerk.aspectDemo.context.AppContext;
import org.springframework.stereotype.Component;

@Component
public class WelcomePrompt implements Prompt {

    @Override
    public Prompt run() {
        System.out.println("Welcome to the employee management system.");
        System.out.print("Follow the main menu prompts to use this system. Manage employees by adding their info, ");
        System.out.print("edit the info or delete the employee from the directory. Any time you are prompted to enter");
        System.out.println("an id, you may only enter the first few digits. It must be unambiguous.");

        return (Prompt) AppContext.getContext().getBean("mainMenuPrompt");
    }
}
