package com.gmail.antoniodauriadev.deque.exceptions;

public class EmptyDequeException extends RuntimeException {

    public EmptyDequeException(String err) {
        super(err);
    }

    public EmptyDequeException() {
        super("The deque is empty.");
    }
}