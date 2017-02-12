package com.gmail.antoniodauriadev.exceptions.entry;

public class InvalidEntryException extends RuntimeException {

    public InvalidEntryException() {
        super("The entry is not valid.");
    }

    public InvalidEntryException(String error) {
        super(error);
    }

}