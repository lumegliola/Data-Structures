package com.gmail.antoniodauriadev.queue;

interface Queue<E> {

    /**Returns the queue's size*/
    int size();

    /**Returns true if the queue is empty*/
    boolean isEmpty();

    /**Returns the first queue's element*/
    E front() throws EmptyQueueException;

    /**Adds an element at the queue's bottom*/
    void enqueue(E element);

    /**Returns the first queue's element and also remove it*/
    E dequeue() throws EmptyQueueException;

}
