package ru.kata.spring.boot_security.demo.util;

public class UserNotUpdateException extends RuntimeException {
    public UserNotUpdateException(String message) {
        super(message);
    }
}
