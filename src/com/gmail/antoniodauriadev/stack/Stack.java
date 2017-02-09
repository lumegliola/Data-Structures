package com.gmail.antoniodauriadev.stack;

import com.gmail.antoniodauriadev.stack.exceptions.EmptyStackException;

interface Stack<E> {

    /**@return The stack's size*/
    int size();

    /**@return True if the stack is empty*/
    boolean isEmpty();

    /**Removes the first element on the stack's top
     * @return the first element on the stack's top*/
    E pop() throws EmptyStackException;

    /**Adds an element on the stack's top
     * @param element element to add*/
    void push(E element);

    /**@return The last element on the stack's top*/
    E top() throws EmptyStackException;

}
