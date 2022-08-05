package com.github.spencerk.aspectDemo;

import com.github.spencerk.aspectDemo.prompt.Prompt;
import com.github.spencerk.aspectDemo.prompt.WelcomePrompt;
import com.github.spencerk.aspectDemo.context.AppContext;

public class Main {
    public static void main(String[] args) {
        Prompt prompt = (Prompt) AppContext.getContext().getBean("welcomePrompt");

        while(prompt != null) prompt = prompt.run();
    }
}
