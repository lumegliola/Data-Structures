package com.gmail.antoniodauriadev.datastructures.positionlist;

import java.util.Iterator;

import com.gmail.antoniodauriadev.datastructures.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.datastructures.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.datastructures.exceptions.positionlist.EmptyListException;
import com.gmail.antoniodauriadev.datastructures.position.Position;
import com.gmail.antoniodauriadev.datastructures.position.PositionDoublyLinkedNode;

public class NodePositionList<E> implements PositionList<E> {

    private int size;
    private PositionDoublyLinkedNode<E> header, trailer;

    public NodePositionList() {
        this.size = 0;
        this.header = new PositionDoublyLinkedNode<>();
        this.trailer = new PositionDoublyLinkedNode<>();
        this.header.setNext(this.trailer);
        this.trailer.setPrev(this.header);
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
    public Position<E> first() throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException();

        return header.getNext();
    }

    @Override
    public Position<E> last() throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException();

        return trailer.getPrev();
    }

    @Override
    public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        PositionDoublyLinkedNode<E> node = checkPosition(p);
        PositionDoublyLinkedNode<E> nextNode = node.getNext();

        if(nextNode == this.trailer)
            throw new BoundaryViolationException("The list is finished, this is the last position.");

        return nextNode;
    }

    @Override
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        PositionDoublyLinkedNode<E> node = checkPosition(p);
        PositionDoublyLinkedNode<E> prevNode = node.getPrev();

        if(prevNode == this.header)
            throw new BoundaryViolationException("The list is finished, this is the first position.");

        return prevNode;
    }

    @Override
    public void addFirst(E e) {
        PositionDoublyLinkedNode<E> node = new PositionDoublyLinkedNode<>(e, this.header.getNext(), this.header);
        this.header.getNext().setPrev(node);
        this.header.setNext(node);
        this.size++;
    }

    @Override
    public void addLast(E e) {
        PositionDoublyLinkedNode<E> node = new PositionDoublyLinkedNode<>(e, this.trailer, this.trailer.getPrev());
        this.trailer.getPrev().setNext(node);
        this.trailer.setPrev(node);
        this.size++;
    }

    @Override
    public void addAfter(Position<E> p, E e) throws InvalidPositionException {
        PositionDoublyLinkedNode<E> prevNode = checkPosition(p);
        PositionDoublyLinkedNode<E> nodeToAdd = new PositionDoublyLinkedNode<>(e, prevNode.getNext(), prevNode);
        prevNode.getNext().setPrev(nodeToAdd);
        prevNode.setNext(nodeToAdd);
        this.size++;
    }

    @Override
    public void addBefore(Position<E> p, E e) throws InvalidPositionException {
        PositionDoublyLinkedNode<E> nextNode = checkPosition(p);
        PositionDoublyLinkedNode<E> nodeToAdd = new PositionDoublyLinkedNode<>(e, nextNode, nextNode.getPrev());
        nextNode.getPrev().setNext(nodeToAdd);
        nextNode.setPrev(nodeToAdd);
        this.size++;
    }

    @Override
    public E remove(Position<E> p) throws InvalidPositionException {
        PositionDoublyLinkedNode<E> toRemove = checkPosition(p);
        toRemove.getPrev().setNext(toRemove.getNext());
        toRemove.getNext().setPrev(toRemove.getPrev());
        toRemove.setNext(null);
        toRemove.setPrev(null);
        this.size--;
        return toRemove.element();
    }

    @Override
    public E set(Position<E> p, E e) throws InvalidPositionException {
        PositionDoublyLinkedNode<E> toReplace = checkPosition(p);
        E prevElement = toReplace.element();
        toReplace.setElement(e);
        return prevElement;
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> P = new NodePositionList<>();
        if (!isEmpty()) {
            Position<E> p = first();
            while (true) {
                P.addLast(p); // add position p as the last element of list P
                if (p == last())
                    break;
                p = next(p);
            }
        }
        return P; // return P as our Iterable object
    }

    /**Checks the position and cast it to PositionDoublyLinkedNode*/
    private PositionDoublyLinkedNode<E> checkPosition(Position<E> p) throws InvalidPositionException {

        if (p == null)
            throw new InvalidPositionException("The position is null.");

        if (p == header)
            throw new InvalidPositionException ("header is not a valid position.");

        if (p == trailer)
            throw new InvalidPositionException("trailer is not a valid position.");

        try {
            PositionDoublyLinkedNode<E> tmp = (PositionDoublyLinkedNode<E>) p;
            if ((tmp.getPrev() == null) || (tmp.getNext() == null))
                throw new InvalidPositionException("The position is not in the list.");

            return tmp;

        } catch (ClassCastException e) {
            throw new InvalidPositionException("The type of position is not valid for this list.");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(this);
    }
}