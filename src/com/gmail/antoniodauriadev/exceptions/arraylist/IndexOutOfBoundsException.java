package com.gmail.antoniodauriadev.exceptions.arraylist;

public class IndexOutOfBoundsException extends RuntimeException{

    public IndexOutOfBoundsException(String error) {
        super(error);
    }

    public IndexOutOfBoundsException() {
        super("Index out of bounds.");
    }
}
