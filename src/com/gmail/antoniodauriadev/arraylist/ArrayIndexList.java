package com.gmail.antoniodauriadev.arraylist;

import com.gmail.antoniodauriadev.exceptions.arraylist.IndexOutOfBoundsException;

import java.util.Iterator;

public class ArrayIndexList<E> implements IndexList<E> {

    private E[] list;
    private int size;

    public ArrayIndexList() {
        this.size = 0;
        this.list = (E[]) new Object[16];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(E element) {
        if (size() == this.list.length)
            duplicateCapacity();

        this.list[size()] = element;
        this.size++;
    }

    @Override
    public void add(int i, E element) throws IndexOutOfBoundsException {
        if (i > size() || i < 0)
            throw new IndexOutOfBoundsException();

        if (size() == this.list.length)
            duplicateCapacity();

        System.arraycopy(this.list, i - 1, this.list, i, size() + 1 - i);
        this.list[i] = element;
        this.size++;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i >= size() || i < 0)
            throw new IndexOutOfBoundsException();

        return list[i];
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i >= size() || i < 0)
            throw new IndexOutOfBoundsException();

        E element = list[i];
        System.arraycopy(this.list, i + 1, this.list, i, size() - 1 - i);
        this.size--;
        return element;
    }

    @Override
    public E set(int i, E element) throws IndexOutOfBoundsException {
        if (i >= size() || i < 0)
            throw new IndexOutOfBoundsException();

        E prevElement = list[i];
        list[i] = element;
        return  prevElement;
    }

    private void duplicateCapacity() {
        E[] newList = (E[]) new Object[list.length * 2];
        System.arraycopy(this.list, 0, newList, 0, list.length);
        this.list = newList;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(this);
    }
}