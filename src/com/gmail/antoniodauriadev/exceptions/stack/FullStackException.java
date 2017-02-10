package com.gmail.antoniodauriadev.exceptions.stack;

public class FullStackException extends RuntimeException {

    public FullStackException(String err) {
        super (err);
    }

    public FullStackException() {
        super("The stack is full.");
    }
}
