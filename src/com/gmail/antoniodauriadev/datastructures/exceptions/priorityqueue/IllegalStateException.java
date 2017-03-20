package com.gmail.antoniodauriadev.datastructures.exceptions.priorityqueue;

public class IllegalStateException extends RuntimeException {

    public IllegalStateException() {
        super("Illegal state.");
    }

    public IllegalStateException(String error) {
        super(error);
    }

}