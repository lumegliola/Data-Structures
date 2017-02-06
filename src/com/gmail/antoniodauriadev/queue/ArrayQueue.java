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

    public E dequeue() throws EmptyQueueException {
        E element;
        if (isEmpty())
            throw new EmptyQueueException("La coda e` vuota.");
        element = Q[front];
        Q[front] = null;
        front = (front + 1)% capacity;
        return element;
    }

    public void enqueue(E element) {
        if (size() == capacity - 1)
            throw new FullQueueException("La coda e` piena.");
        Q[rear] = element;
        rear = (rear + 1)% capacity;
    }

    public E front() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("La coda e` vuota.");
        return Q[front];
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public int size() {
        return (capacity - front + rear) % capacity;
    }
}
