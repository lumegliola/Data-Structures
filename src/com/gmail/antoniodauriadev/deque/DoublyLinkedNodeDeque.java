package com.gmail.antoniodauriadev.deque;

import com.gmail.antoniodauriadev.deque.exceptions.EmptyDequeException;
import com.gmail.antoniodauriadev.node.DoublyLinkedNode;

public class DoublyLinkedNodeDeque<E> implements Deque<E> {

    private DoublyLinkedNode<E> header;
    private DoublyLinkedNode<E> trailer;
    private int size;

    public DoublyLinkedNodeDeque() {
        this.header = new DoublyLinkedNode<>();
        this.trailer = new DoublyLinkedNode<>();
        this.header.setNext(this.trailer);
        this.trailer.setPrev(this.header);
        this.size = 0;
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
    public E getFirst() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException();

        return this.header.getNext().getElement();
    }

    @Override
    public E getLast() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException();

        return this.trailer.getPrev().getElement();
    }

    @Override
    public void addFirst(E element) {
        DoublyLinkedNode<E> second = header.getNext();
        DoublyLinkedNode<E> first = new DoublyLinkedNode<>(element, second, this.header);
        this.header.setNext(first);
        second.setPrev(first);
        this.size++;
    }

    @Override
    public void addLast(E element) {
        DoublyLinkedNode<E> penultimate = this.trailer.getPrev();
        DoublyLinkedNode<E> last = new DoublyLinkedNode<>(element, this.trailer, penultimate);
        this.trailer.setPrev(last);
        penultimate.setNext(last);
        this.size++;
    }

    @Override
    public E removeFirst() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException();

        DoublyLinkedNode<E> toBeRemoved = header.getNext();
        DoublyLinkedNode<E> second = toBeRemoved.getNext();
        second.setPrev(this.header);
        this.header.setNext(second);
        this.size--;

        return toBeRemoved.getElement();
    }

    @Override
    public E removeLast() throws EmptyDequeException {
        if(isEmpty())
            throw new EmptyDequeException();

        DoublyLinkedNode<E> toBeRemoved = trailer.getPrev();
        DoublyLinkedNode<E> penultimate = toBeRemoved.getPrev();
        penultimate.setNext(this.trailer);
        this.trailer.setPrev(penultimate);
        this.size--;

        return toBeRemoved.getElement();
    }
}
