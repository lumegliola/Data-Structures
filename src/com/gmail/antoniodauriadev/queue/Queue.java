package com.gmail.antoniodauriadev.queue;

import com.gmail.antoniodauriadev.exceptions.queue.EmptyQueueException;

interface Queue<E> {

    /**@return Size of the queue.*/
    int size();

    /**@return True if the queue is empty.*/
    boolean isEmpty();

    /**@return First element of the queue.*/
    E front() throws EmptyQueueException;

    /**Adds an element at the bottom of the queue.*/
    void enqueue(E element);

    /**Removes the first element of the queue.
     * @return Removed element.*/
    E dequeue() throws EmptyQueueException;

}
