package com.gmail.antoniodauriadev.arraylist.exceptions;

public class IndexOutOfBoundsException extends RuntimeException{

    public IndexOutOfBoundsException(String error) {
        super(error);
    }

    public IndexOutOfBoundsException() {
        super("Index out of bounds.");
    }
}
