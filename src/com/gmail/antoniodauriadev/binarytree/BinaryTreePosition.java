package com.gmail.antoniodauriadev.binarytree;

import com.gmail.antoniodauriadev.position.Position;

interface BinaryTreePosition<E> extends Position<E> {

    /**Stets the element.*/
    void setElement(E element);

    /**@return The left child.*/
    BinaryTreePosition<E> getLeft();

    /**Sets the left child.*/
    void setLeft(BinaryTreePosition<E> position);

    /**@return The right child.*/
    BinaryTreePosition<E> getRight();

    /**Sets the right child.*/
    void setRight(BinaryTreePosition<E> position);

    /**@return The parent.*/
    BinaryTreePosition<E> getParent();

    /**Sets the parent.*/
    void setParent(BinaryTreePosition<E> position);

}