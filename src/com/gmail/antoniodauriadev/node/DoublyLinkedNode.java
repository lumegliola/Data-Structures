package com.gmail.antoniodauriadev.node;

public class DoublyLinkedNode<E> {

    private E element;
    private DoublyLinkedNode<E> next;
    private DoublyLinkedNode<E> prev;

    /**Creates a doubly linked node.
     * @param element The node's element.
     * @param next The next node.
     * @param prev The previous node.*/
    public DoublyLinkedNode(E element, DoublyLinkedNode<E> next, DoublyLinkedNode<E> prev) {
        setElement(element);
        setNext(next);
        setPrev(prev);
    }

    /**Creates a doubly linked node. All parameters will be null.*/
    public DoublyLinkedNode() {
        this(null, null, null);
    }

    /**@return The node's element*/
    public E getElement() {
        return this.element;
    }

    /**Sets the node's element*/
    public void setElement(E element) {
        this.element = element;
    }

    /**@return The next node*/
    public DoublyLinkedNode<E> getNext() {
        return this.next;
    }

    /**Sets the next node*/
    public void setNext(DoublyLinkedNode<E> next) {
        this.next = next;
    }

    /**@return The previous node*/
    public DoublyLinkedNode<E> getPrev() {
        return this.prev;
    }

    /**Sets the previous node*/
    public void setPrev(DoublyLinkedNode<E> prev) {
        this.prev = prev;
    }
}
