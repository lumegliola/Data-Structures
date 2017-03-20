package com.gmail.antoniodauriadev.datastructures.arraylist;

import com.gmail.antoniodauriadev.datastructures.exceptions.arraylist.ElementNotFoundException;
import com.gmail.antoniodauriadev.datastructures.exceptions.arraylist.IndexOutOfBoundsException;

interface IndexList<E> extends Iterable<E>{

    /**@return Size of the arraylist.*/
    int size();

    /**@return True if the arraylist is empty.*/
    boolean isEmpty();

    /**Adds an element to the next position.
     * @param element Element to add.*/
    void add(E element);

    /**Adds an element.
     * @param i Position.
     * @param element Element to add.*/
    void add(int i, E element) throws IndexOutOfBoundsException;

    /**@return Element in the required position.
     * @param i Position.*/
    E get(int i) throws IndexOutOfBoundsException;

    /**Removes the element in the required position.
     * @param i Position.
     * @return Removed element.*/
    E remove(int i) throws IndexOutOfBoundsException;

    /**Removes the required element.
     * @param element Element to remove.
     * @return Removed element.*/
    E remove(E element) throws ElementNotFoundException, IndexOutOfBoundsException;

    /**Sets an element in the required position.
     * @param i Position.
     * @param element Element to set.*
     * @return Previous element in the required position*/
    E set(int i, E element) throws IndexOutOfBoundsException;

}