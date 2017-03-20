package com.gmail.antoniodauriadev.binarytree;

import com.gmail.antoniodauriadev.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.tree.Tree;

public interface BinaryTree<E> extends Tree<E> {

    /**@return Left child.*/
    Position<E> left(Position<E> position) throws InvalidPositionException, BoundaryViolationException;

    /**@return Right child.*/
    Position<E> right(Position<E> position) throws InvalidPositionException, BoundaryViolationException;

    /**@return True if the chosen node has a left child.*/
    boolean hasLeft(Position<E> position) throws InvalidPositionException;

    /**@return True if the chosen node has a right child.*/
    boolean hasRight(Position<E> position) throws InvalidPositionException;

}
