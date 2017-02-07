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
     * @param element node's element.
     * @param next Link to the next node.*/
    public Node(E element, Node<E> next) {
        setElement(element);
        setNext(next);
    }

    /**@return The next node*/
    public Node<E> getNext() {
        return this.next;
    }

    /**Set the next node
     * @param next Node to set as next*/
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**@return The nodes element*/
    public E getElement() {
        return this.element;
    }

    /**Set the node's element
     * @param element element to set*/
    public void setElement(E element) {
        this.element = element;
    }

}