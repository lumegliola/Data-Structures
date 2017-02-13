package com.gmail.antoniodauriadev.exceptions.arraylist;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String error) {
        super(error);
    }

    public ElementNotFoundException() {
        super("Element not found.");
    }
}
