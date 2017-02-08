package com.gmail.antoniodauriadev.arraylist;

public interface IndexList<E> {

    /**@return The arraylist's size.*/
    int size();

    /**@return True if the arraylist is empty.*/
    boolean isEmpty();

    /**Adds an element to the next position.
     * @param element element to add.*/
    void add(E element);

    /**Adds an element.
     * @param i position.
     * @param element element to add.*/
    void add(int i, E element) throws IndexOutOfBoundsException;

    /**@return The element in the required position.
     * @param i Position.*/
    E get(int i) throws IndexOutOfBoundsException;

    /**Removes the element in the required position.
     * @param i Position.
     * @return Removed element.*/
    E remove(int i) throws IndexOutOfBoundsException;

    /**Sets an element in the required position.
     * @param i Position.
     * @param element element to set.*
     * @return The previous element in the required position*/
    E set(int i, E element) throws IndexOutOfBoundsException;

}