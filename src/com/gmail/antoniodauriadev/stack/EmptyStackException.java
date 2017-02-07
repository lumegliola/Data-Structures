package com.gmail.antoniodauriadev.stack;

class EmptyStackException extends RuntimeException {

    EmptyStackException(String err) {
        super (err);
    }

    EmptyStackException() {
        super("The stack is empty.");
    }
}
