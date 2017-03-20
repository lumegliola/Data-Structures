package com.gmail.antoniodauriadev.datastructures.exceptions.stack;

public class FullStackException extends RuntimeException {

    public FullStackException(String err) {
        super (err);
    }

    public FullStackException() {
        super("The stack is full.");
    }
}
