package com.gmail.antoniodauriadev.stack;

public class ArrayStack<E> implements Stack<E> {
    private int capacity;
    private E s[];
    private int top = -1;

    public ArrayStack(int capacity){
        this.capacity = capacity;
        s = (E[]) new Object[this.capacity];
    }

    public int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public E top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("Stack is empty.");
        return s[top];
    }

    public void push(E element) {
        if(size() == capacity)
            throw new FullStackException("Stack is full.");
        s[++top] = element;
    }

    public E pop() throws EmptyStackException {
        E element;
        if (isEmpty())
            throw new EmptyStackException("Stack is empty.");
        element = s[top];
        s[top--] = null;
        return element;
    }

}