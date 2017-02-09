package com.gmail.antoniodauriadev.tree.exceptions;

public class EmptyTreeException extends RuntimeException {

    public EmptyTreeException() {
        super("The tree is empty.");
    }

    public EmptyTreeException(String error) {
        super(error);
    }

}