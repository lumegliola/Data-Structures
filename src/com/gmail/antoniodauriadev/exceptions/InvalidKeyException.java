package com.gmail.antoniodauriadev.exceptions;

public class InvalidKeyException extends RuntimeException {

    public InvalidKeyException() {
        super("The chosen position is invalid.");
    }

    public InvalidKeyException(String error) {
        super(error);
    }

}