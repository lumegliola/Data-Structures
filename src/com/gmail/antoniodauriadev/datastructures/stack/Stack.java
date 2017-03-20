package com.gmail.antoniodauriadev.datastructures.stack;

import com.gmail.antoniodauriadev.datastructures.exceptions.stack.EmptyStackException;

interface Stack<E> {

    /**@return Size of the stack*/
    int size();

    /**@return True if the stack is empty*/
    boolean isEmpty();

    /**Removes the first element on the top
     * @return Removed element*/
    E pop() throws EmptyStackException;

    /**Adds an element on the top
     * @param element Element to add*/
    void push(E element);

    /**@return Last added element.*/
    E top() throws EmptyStackException;

}
