package com.github.spencerk.aspectDemo.util;

import com.github.spencerk.aspectDemo.context.AppContext;

import java.util.Scanner;

public class UserInput {
    public static String getString(String prompt, String... acceptable) {
        Scanner scanner = AppContext.getContext().getBean(Scanner.class);
        String input;

        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
        } while(arrayNotContains(acceptable, input));

        return input;
    }

    public static char getChar(String prompt, Character... acceptable) {
        Scanner scanner = AppContext.getContext().getBean(Scanner.class);
        String  inputStr;
        char    inputChar;

        do {
            System.out.println(prompt);
            inputStr = scanner.nextLine().trim();
            inputChar = inputStr == null ? 0 : inputStr.charAt(0);
        } while(arrayNotContains(acceptable, inputChar));

        return inputChar;
    }

    private static boolean arrayNotContains(Object[] arr, Object val) {
        if(arr.length == 0) return false;
        for(Object o : arr) if(o.equals(val)) return false;

        return true;
    }

    public static String formatPhoneNumber(String input) {
        if( ! input.matches("\\d{10}")) return input;

        return String.format("(%s) %s %s", input.substring(0,3), input.substring(3, 6), input.substring(6));
    }
}
