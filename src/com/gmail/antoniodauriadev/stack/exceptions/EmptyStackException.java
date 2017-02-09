package com.gmail.antoniodauriadev.stack.exceptions;

public class EmptyStackException extends RuntimeException {

    public EmptyStackException(String err) {
        super (err);
    }

    public EmptyStackException() {
        super("The stack is empty.");
    }
}
