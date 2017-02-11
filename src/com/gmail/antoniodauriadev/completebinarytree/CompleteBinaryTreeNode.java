package com.gmail.antoniodauriadev.completebinarytree;

import com.gmail.antoniodauriadev.position.Position;

class CompleteBinaryTreeNode<E> implements Position<E>{

    private E element;
    private int index;

    CompleteBinaryTreeNode(E element, int index) {
        this.element = element;
        this.index = index;
    }

    @Override
    public E element() {
        return this.element;
    }

    /**@return The position's index.*/
    public int index() {
        return this.index;
    }

    /**Sets a new element in this node.
     * @return The previous element.*/
    public E setElement(E element) {
        E temp = element();
        this.element = element;
        return temp;
    }

    @Override
    public String toString() {
        return("[" + element + "," + index + "]");
    }

}
