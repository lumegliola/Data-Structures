package com.gmail.antoniodauriadev.stack;

interface Stack<E> {

    int size();
    boolean isEmpty();
    E top() throws EmptyStackException;
    void push(E element);
    E pop() throws EmptyStackException;

}
