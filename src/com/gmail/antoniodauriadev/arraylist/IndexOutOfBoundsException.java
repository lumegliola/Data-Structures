package com.gmail.antoniodauriadev.arraylist;

class IndexOutOfBoundsException extends RuntimeException{

    IndexOutOfBoundsException(String error) {
        super(error);
    }

    IndexOutOfBoundsException() {
        super("Index out of bounds.");
    }
}
