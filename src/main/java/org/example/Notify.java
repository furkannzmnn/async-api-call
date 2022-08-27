package org.example;

public abstract class Notify {
    private final String message;

    public Notify(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
