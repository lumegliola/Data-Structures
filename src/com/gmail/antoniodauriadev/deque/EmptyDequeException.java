package com.gmail.antoniodauriadev.deque;

class EmptyDequeException extends RuntimeException {

    EmptyDequeException(String err) {
        super(err);
    }

    EmptyDequeException() {
        super("The deque is empty.");
    }
}