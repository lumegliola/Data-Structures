package com.gmail.antoniodauriadev.datastructures.stack;

import com.gmail.antoniodauriadev.datastructures.exceptions.stack.EmptyStackException;
import com.gmail.antoniodauriadev.datastructures.exceptions.stack.FullStackException;

public class ArrayStack<E> implements Stack<E> {
    private int capacity;
    private E s[];
    private int top = -1;

    public ArrayStack(int capacity){
        this.capacity = capacity;
        s = (E[]) new Object[this.capacity];
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return (top < 0);
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Stack is empty.");
        return s[top];
    }

    @Override
    public void push(E element) {
        if(size() == capacity)
            throw new FullStackException("Stack is full.");
        s[++top] = element;
    }

    @Override
    public E pop() throws EmptyStackException {
        E element;
        if (isEmpty())
            throw new EmptyStackException("Stack is empty.");
        element = s[top];
        s[top--] = null;
        return element;
    }

}