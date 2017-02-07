package com.gmail.antoniodauriadev.queue;

import com.gmail.antoniodauriadev.node.Node;

public class NodeQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public NodeQueue (){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E front() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("The queue is empty.");

        return this.head.getElement();
    }

    @Override
    public void enqueue(E element) {
        Node<E> tmp = new Node<>(element, null);
        if (isEmpty()) {
            this.head = tmp;
            this.tail = tmp;
        }
        else {
            this.tail.setNext(tmp);
            this.tail = this.tail.getNext();
        }
        this.size++;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("The queue is empty.");

        E tmp = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;
        if (isEmpty())
            this.tail = null;
        return tmp;
    }
}