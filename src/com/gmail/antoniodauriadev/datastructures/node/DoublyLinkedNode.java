package com.gmail.antoniodauriadev.datastructures.node;

public class DoublyLinkedNode<E> {

    private E element;
    private DoublyLinkedNode<E> next;
    private DoublyLinkedNode<E> prev;

    /**Creates a doubly linked node.
     * @param element Element of the node.
     * @param next Next node.
     * @param prev Previous node.*/
    public DoublyLinkedNode(E element, DoublyLinkedNode<E> next, DoublyLinkedNode<E> prev) {
        setElement(element);
        setNext(next);
        setPrev(prev);
    }

    /**Creates a doubly linked node. All parameters will be null.*/
    public DoublyLinkedNode() {
        this(null, null, null);
    }

    /**@return Element of the node.*/
    public E getElement() {
        return this.element;
    }

    /**Sets the element of the node.*/
    public void setElement(E element) {
        this.element = element;
    }

    /**@return Next node.*/
    public DoublyLinkedNode<E> getNext() {
        return this.next;
    }

    /**Sets the next node.*/
    public void setNext(DoublyLinkedNode<E> next) {
        this.next = next;
    }

    /**@return Previous node.*/
    public DoublyLinkedNode<E> getPrev() {
        return this.prev;
    }

    /**Sets the previous node.*/
    public void setPrev(DoublyLinkedNode<E> prev) {
        this.prev = prev;
    }
}
