package com.gmail.antoniodauriadev.queue;

import com.gmail.antoniodauriadev.queue.exceptions.EmptyQueueException;
import com.gmail.antoniodauriadev.queue.exceptions.FullQueueException;

public class ArrayQueue<E> implements Queue<E> {

    private int capacity;
    private E q[];
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.q = (E[]) new Object[this.capacity];

    }

    @Override
    public E dequeue() throws EmptyQueueException {
        E element;
        if (isEmpty())
            throw new EmptyQueueException();
        element = this.q[this.front];
        this.q[this.front] = null;
        this.front = (this.front + 1)% this.capacity;
        return element;
    }

    @Override
    public void enqueue(E element) {
        if (size() == this.capacity - 1)
            throw new FullQueueException();
        this.q[this.rear] = element;
        this.rear = (this.rear + 1)% this.capacity;
    }

    @Override
    public E front() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        return this.q[this.front];
    }

    @Override
    public boolean isEmpty() {
        return (this.front == this.rear);
    }

    @Override
    public int size() {
        return (this.capacity - this.front + this.rear) % this.capacity;
    }
}
