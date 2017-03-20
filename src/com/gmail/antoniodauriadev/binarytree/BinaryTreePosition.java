package com.gmail.antoniodauriadev.binarytree;

import com.gmail.antoniodauriadev.position.Position;

interface BinaryTreePosition<E> extends Position<E> {

    /**Sets the element.*/
    void setElement(E element);

    /**@return Left child.*/
    BinaryTreePosition<E> getLeft();

    /**Sets the left child.*/
    void setLeft(BinaryTreePosition<E> position);

    /**@return Right child.*/
    BinaryTreePosition<E> getRight();

    /**Sets the right child.*/
    void setRight(BinaryTreePosition<E> position);

    /**@return Parent.*/
    BinaryTreePosition<E> getParent();

    /**Sets the parent.*/
    void setParent(BinaryTreePosition<E> position);

}