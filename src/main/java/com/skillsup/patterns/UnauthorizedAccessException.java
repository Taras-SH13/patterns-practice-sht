package com.skillsup.patterns;

public class UnauthorizedAccessException extends RuntimeException {


    public UnauthorizedAccessException(String message) {
        super(message);
    }
}

