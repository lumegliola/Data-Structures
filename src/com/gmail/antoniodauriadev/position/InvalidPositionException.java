package com.gmail.antoniodauriadev.position;

class InvalidPositionException extends RuntimeException {

    InvalidPositionException() {
        super("The chosen position is invalid.");
    }

    InvalidPositionException(String error) {
        super(error);
    }

}