package com.gmail.antoniodauriadev.datastructures.exceptions;

public class BoundaryViolationException extends RuntimeException {

    public BoundaryViolationException() {
        super("Boundary violation.");
    }

    public BoundaryViolationException(String error) {
        super(error);
    }

}