package com.gmail.antoniodauriadev.position;

class EmptyListException extends RuntimeException {

    EmptyListException() {
        super("The positionList is empty.");
    }

    EmptyListException(String error) {
        super(error);
    }

}