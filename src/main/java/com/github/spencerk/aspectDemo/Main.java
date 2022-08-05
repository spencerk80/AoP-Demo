package com.github.spencerk.aspectDemo;

import com.github.spencerk.aspectDemo.Prompt.Prompt;
import com.github.spencerk.aspectDemo.Prompt.WelcomePrompt;
import com.github.spencerk.aspectDemo.context.AppContext;

public class Main {
    public static void main(String[] args) {
        Prompt prompt = AppContext.getContext().getBean(WelcomePrompt.class);

        while(prompt != null) prompt = prompt.run();
    }
}
