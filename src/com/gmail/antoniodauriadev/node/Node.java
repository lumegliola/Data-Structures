package com.gmail.antoniodauriadev.node;

public class Node<E> {
    private E element;
    private Node<E> next;

    /**Creates a new node.
     * element = null
     * next = null*/
    public Node() {
        this(null, null);
    }

    /**Creates a new node.
     * @param element Element of the node.
     * @param next Link to the next node.*/
    public Node(E element, Node<E> next) {
        setElement(element);
        setNext(next);
    }

    /**@return Next node.*/
    public Node<E> getNext() {
        return this.next;
    }

    /**Sets the next node.
     * @param next Node to set as next.*/
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**@return Element of the node.*/
    public E getElement() {
        return this.element;
    }

    /**Sets element of the node.
     * @param element Element to set*/
    public void setElement(E element) {
        this.element = element;
    }

}