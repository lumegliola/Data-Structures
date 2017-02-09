package com.gmail.antoniodauriadev.tree.exceptions;

public class NonEmptyTreeException extends RuntimeException {

    public NonEmptyTreeException() {
        super("The tree is not empty.");
    }

    public NonEmptyTreeException(String error) {
        super(error);
    }

}