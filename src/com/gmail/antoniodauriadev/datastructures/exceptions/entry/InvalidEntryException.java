package com.gmail.antoniodauriadev.datastructures.exceptions.entry;

public class InvalidEntryException extends RuntimeException {

    public InvalidEntryException() {
        super("The entry is not valid.");
    }

    public InvalidEntryException(String error) {
        super(error);
    }

}