package com.gmail.antoniodauriadev.queue;

interface Queue<E> {

    int size();
    boolean isEmpty();
    E front() throws EmptyQueueException;
    void enqueue(E element);
    E dequeue() throws EmptyQueueException;

}
