package com.gmail.antoniodauriadev.positionlist.exceptions;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        super("The positionList is empty.");
    }

    public EmptyListException(String error) {
        super(error);
    }

}