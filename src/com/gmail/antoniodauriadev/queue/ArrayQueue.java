package com.gmail.antoniodauriadev.queue;

public class ArrayQueue<E> implements Queue<E> {

    private int capacity;
    private E Q[];
    private int front;
    private int rear;

    public ArrayQueue(int cap) {
        capacity = cap;
        Q = (E[]) new Object[capacity];

    }

    @Override
    public E dequeue() throws EmptyQueueException {
        E element;
        if (isEmpty())
            throw new EmptyQueueException("The queue is empty.");
        element = Q[front];
        Q[front] = null;
        front = (front + 1)% capacity;
        return element;
    }

    @Override
    public void enqueue(E element) {
        if (size() == capacity - 1)
            throw new FullQueueException("The queue is full.");
        Q[rear] = element;
        rear = (rear + 1)% capacity;
    }

    @Override
    public E front() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("The queue is empty.");
        return Q[front];
    }

    @Override
    public boolean isEmpty() {
        return (front == rear);
    }

    @Override
    public int size() {
        return (capacity - front + rear) % capacity;
    }
}
