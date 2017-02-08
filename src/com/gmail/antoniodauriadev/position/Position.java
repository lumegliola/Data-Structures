package com.gmail.antoniodauriadev.position;

interface Position<E> {

    /**@return The element in this position.*/
    E element() throws InvalidPositionException;

}