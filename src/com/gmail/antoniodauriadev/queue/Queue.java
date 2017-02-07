package com.gmail.antoniodauriadev.queue;

interface Queue<E> {

    /**@return The queue's size*/
    int size();

    /**@return True if the queue is empty*/
    boolean isEmpty();

    /**@return The first queue's element*/
    E front() throws EmptyQueueException;

    /**Adds an element at the queue's bottom*/
    void enqueue(E element);

    /**Removes the first queue's element
     * @return The first queue's element*/
    E dequeue() throws EmptyQueueException;

}
