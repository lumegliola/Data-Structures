package com.gmail.antoniodauriadev.stack;

interface Stack<E> {

    /**Returns the stack's size*/
    int size();

    /**Returns true if the stack is empty*/
    boolean isEmpty();

    /**Returns the last element on the stack's top and also remove it from the stack*/
    E pop() throws EmptyStackException;

    /**Adds an element on the stack's top
     * @param element element to add*/
    void push(E element);

    /**Returns the last element on the stack's top*/
    E top() throws EmptyStackException;

}
