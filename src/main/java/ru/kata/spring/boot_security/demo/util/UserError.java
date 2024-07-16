package ru.kata.spring.boot_security.demo.util;

public class UserError {
    private String message;

    public UserError(String s) {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
