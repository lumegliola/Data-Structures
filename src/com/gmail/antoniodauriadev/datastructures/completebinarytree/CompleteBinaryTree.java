package com.gmail.antoniodauriadev.datastructures.completebinarytree;

import com.gmail.antoniodauriadev.datastructures.binarytree.BinaryTree;
import com.gmail.antoniodauriadev.datastructures.position.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {

    /**Adds an element to the last position.*/
    Position<E> add(E element);

    /**Removes the last added element.*/
    E remove();
}