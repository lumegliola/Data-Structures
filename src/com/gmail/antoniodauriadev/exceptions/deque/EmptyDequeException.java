package com.gmail.antoniodauriadev.exceptions.deque;

public class EmptyDequeException extends RuntimeException {

    public EmptyDequeException(String err) {
        super(err);
    }

    public EmptyDequeException() {
        super("The deque is empty.");
    }
}