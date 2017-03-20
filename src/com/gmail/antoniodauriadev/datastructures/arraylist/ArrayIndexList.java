package com.gmail.antoniodauriadev.datastructures.arraylist;

import java.util.Iterator;

import com.gmail.antoniodauriadev.datastructures.exceptions.arraylist.ElementNotFoundException;
import com.gmail.antoniodauriadev.datastructures.exceptions.arraylist.IndexOutOfBoundsException;

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
    public E remove(E element) throws ElementNotFoundException, IndexOutOfBoundsException {
        int i = 0;
        for (E e : this) {
            if (e == element) {
                remove(i);
                return e;
            }
            i++;
        }
        throw new ElementNotFoundException();
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

    @Override
    public String toString() {
        String s = "ArrayIndexList: (";
        boolean first = true;
        for(E e : this) {
            if (first) {
                first = false;
                s = s + e.toString();
            }
            else
                s = s + ", " + e.toString();
        }
        return s + ")";
    }
}