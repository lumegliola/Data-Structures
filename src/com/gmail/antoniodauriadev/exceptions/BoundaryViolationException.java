package com.gmail.antoniodauriadev.exceptions;

public class BoundaryViolationException extends RuntimeException {

    public BoundaryViolationException() {
        super("Boundary violation.");
    }

    public BoundaryViolationException(String error) {
        super(error);
    }

}