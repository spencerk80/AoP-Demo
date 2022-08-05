package com.github.spencerk.aspectDemo.context;

import com.github.spencerk.aspectDemo.AoP.LoggingAspects;
import com.github.spencerk.aspectDemo.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppContext {
    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        if(context == null) context = new AnnotationConfigApplicationContext(AppConfig.class);
        return context;
    }
}
