package com.gmail.antoniodauriadev.datastructures.deque;

import com.gmail.antoniodauriadev.datastructures.exceptions.deque.EmptyDequeException;

interface Deque<E> {

    /**@return Size of the deque.*/
    int size();

    /**@return True if the deque is empty.*/
    boolean isEmpty();

    /**@return First element.*/
    E getFirst() throws EmptyDequeException;

    /**@return Last element.*/
    E getLast() throws EmptyDequeException;

    /**Adds an element in the first position.*/
    void addFirst(E element);

    /**Adds an element in the last position.*/
    void addLast(E element);

    /**Removes the element in the first position.
     * @return Removed item.*/
    E removeFirst() throws EmptyDequeException;

    /**Removes the element in the last position.
     * @return Removed item.*/
    E removeLast() throws EmptyDequeException;
}
