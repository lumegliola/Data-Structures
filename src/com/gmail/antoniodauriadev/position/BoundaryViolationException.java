package com.gmail.antoniodauriadev.position;

class BoundaryViolationException extends RuntimeException {

    BoundaryViolationException() {
        super("Boundary violation.");
    }

    BoundaryViolationException(String error) {
        super(error);
    }

}