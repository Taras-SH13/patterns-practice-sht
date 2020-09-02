package com.skillsup.patterns;

public abstract class Handler {
    private Handler next;

    public Handler linkWith(Handler next) {
        this.next = next;
        return next;
    }
}
