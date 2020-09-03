package com.skillsup.patterns;

public class UnauthorizedAccessException extends NullPointerException {


    public UnauthorizedAccessException(String message) {
        super(message);
    }
}

