package com.gmail.antoniodauriadev.datastructures.exceptions.tree;

public class EmptyTreeException extends RuntimeException {

    public EmptyTreeException() {
        super("The tree is empty.");
    }

    public EmptyTreeException(String error) {
        super(error);
    }

}