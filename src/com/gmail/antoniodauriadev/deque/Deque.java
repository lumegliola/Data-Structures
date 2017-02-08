package com.gmail.antoniodauriadev.deque;

interface Deque<E> {

    /**@return The deque's size.*/
    int size();

    /**@return True if the deque is empty.*/
    boolean isEmpty();

    /**@return The first element*/
    E getFirst() throws EmptyDequeException;

    /**@return The last element*/
    E getLast() throws EmptyDequeException;

    /**Adds an element in the first position*/
    void addFirst(E element);

    /**Adds an element in the last position*/
    void addLast(E element);

    /**Removes the element in the first position
     * @return The first item removed*/
    E removeFirst() throws EmptyDequeException;

    /**Removes the element in the last posizion
     * @return the last item removed*/
    E removeLast() throws EmptyDequeException;
}
