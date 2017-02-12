package com.gmail.antoniodauriadev.positionlist;

import com.gmail.antoniodauriadev.position.Position;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ElementIterator<E> implements Iterator<E> {

    private PositionList<E> list;
    private Position<E> cursor;
    private boolean removed;

    ElementIterator (PositionList<E> list) {
        this.list = list;
        this.cursor = (this.list.isEmpty())? null : this.list.first();
        this.removed = true;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public E next() throws NoSuchElementException {
        if (this.cursor == null)
            throw new NoSuchElementException("There is not a next element.");

        E toReturn = this.cursor.element();
        this.cursor = (this.cursor == this.list.last()) ? null : this.list.next(this.cursor);
        this.removed = false;
        return toReturn;
    }

    @Override
    public void remove() {
        if(!this.removed) {
            if (this.cursor == null)
                this.list.remove(this.list.last());

            this.list.remove(this.list.prev(this.cursor));
        }
    }
}