package com.gmail.antoniodauriadev.completebinarytree;

import com.gmail.antoniodauriadev.binarytree.BinaryTree;
import com.gmail.antoniodauriadev.position.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {

    /**Adds an element to the last position.*/
    Position<E> add(E element);

    /**Removes the last added element.*/
    E remove();
}