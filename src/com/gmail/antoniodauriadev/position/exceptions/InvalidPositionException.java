package com.gmail.antoniodauriadev.position.exceptions;

public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException() {
        super("The chosen position is invalid.");
    }

    public InvalidPositionException(String error) {
        super(error);
    }

}