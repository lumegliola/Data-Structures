package com.gmail.antoniodauriadev.exceptions.priorityqueue;

public class IllegalStateException extends RuntimeException {

    public IllegalStateException() {
        super("Illegal state.");
    }

    public IllegalStateException(String error) {
        super(error);
    }

}