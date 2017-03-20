package com.gmail.antoniodauriadev.datastructures.exceptions.entry;

public class InvalidKeyException extends RuntimeException {

    public InvalidKeyException() {
        super("The key is invalid.");
    }

    public InvalidKeyException(String error) {
        super(error);
    }

}