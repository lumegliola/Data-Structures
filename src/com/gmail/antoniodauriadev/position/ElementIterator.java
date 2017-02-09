package com.gmail.antoniodauriadev.position;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ElementIterator<E> implements Iterator<E> {

    private PositionList<E> list;
    private Position<E> cursor;

    ElementIterator (PositionList<E> list) {
        this.list = list;
        this.cursor = (this.list.isEmpty())? null : this.list.first();
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public E next() throws NoSuchElementException {
        if (cursor == null)
            throw new NoSuchElementException("There is not a next element.");

        E toReturn = cursor.element();
        cursor = (cursor == list.last()) ? null : list.next(cursor);
        return toReturn;
    }
}