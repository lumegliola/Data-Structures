package com.gmail.antoniodauriadev.position;

public class PositionDoublyLinkedNode<E> implements Position<E> {

    private PositionDoublyLinkedNode<E> next, prev;
    private E element;

    /**Creates a position doubly linked node.
     * @param element The node's element.
     * @param next The next node.
     * @param prev The previous node.*/
    public PositionDoublyLinkedNode(E element, PositionDoublyLinkedNode<E> next, PositionDoublyLinkedNode<E> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    /**Creates a position doubly linked node. All parameters will be null.*/
    public PositionDoublyLinkedNode() {
        this(null, null, null);
    }

    /**@return The next node*/
    public PositionDoublyLinkedNode<E> getNext() {
        return this.next;
    }

    /**@return The previous node*/
    public PositionDoublyLinkedNode<E> getPrev() {
        return this.prev;
    }

    /**Sets the next node*/
    public void setNext(PositionDoublyLinkedNode<E> next) {
        this.next = next;
    }

    /**Sets the previous node*/
    public void setPrev(PositionDoublyLinkedNode<E> prev) {
        this.prev = prev;
    }

    /**Sets the node's element*/
    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public E element() {
        if(this.getPrev() == null && this.getNext() == null)
            throw new InvalidPositionException();

        return this.element;
    }


}