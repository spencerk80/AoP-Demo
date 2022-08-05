package com.github.spencerk.aspectDemo.Prompt;

import org.springframework.stereotype.Component;

@Component
public class WelcomePrompt implements Prompt {

    @Override
    public Prompt run() {
        System.out.println("Welcome to the employee management system.");

        return null;
    }
}
