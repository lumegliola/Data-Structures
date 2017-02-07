package com.gmail.antoniodauriadev.stack;

class FullStackException extends RuntimeException {

    FullStackException(String err) {
        super (err);
    }

    FullStackException() {
        super("The stack is full.");
    }
}
