package com.gmail.antoniodauriadev.stack;

import com.gmail.antoniodauriadev.node.Node;

public class NodeStack<E> implements Stack<E> {

    private Node<E> top;
    private int size;

    public NodeStack () {
        this.top = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();

        return this.top.getElement();
    }

    @Override
    public void push(E element) {
        Node<E> n = new Node<>(element, this.top);
        this.size++;
        this.top = n;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException();

        E element = this.top.getElement();
        this.top = this.top.getNext();
        this.size--;
        return element;
    }
}
