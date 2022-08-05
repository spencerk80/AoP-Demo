package com.github.spencerk.aspectDemo.exception;

public class NonUniqueIdException extends Exception {
    public NonUniqueIdException() {
        super("ID entered is ambiguous and matches more than one employee");
    }
}
