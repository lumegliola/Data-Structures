package com.gmail.antoniodauriadev.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ElementIterator<E> implements Iterator<E> {

    private ArrayIndexList<E> list;
    private Integer cursor;
    private boolean removed;

    ElementIterator(ArrayIndexList<E> list) {
        this.list = list;
        this.cursor = 0;
        this.removed = true;
    }

    @Override
    public boolean hasNext() {
        return cursor < list.size();
    }

    @Override
    public E next() throws NoSuchElementException {
        if (cursor >= list.size())
            throw new NoSuchElementException("There is not a next element.");

        E toReturn = list.get(cursor);
        cursor++;
        removed = false;
        return toReturn;
    }

    @Override
    public void remove() {
        if (!removed) {
            cursor--;
            list.remove(cursor);
            removed = true;
        }
    }
}