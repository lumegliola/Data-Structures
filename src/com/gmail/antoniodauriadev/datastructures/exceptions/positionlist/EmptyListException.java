package com.gmail.antoniodauriadev.datastructures.exceptions.positionlist;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        super("The positionList is empty.");
    }

    public EmptyListException(String error) {
        super(error);
    }

}