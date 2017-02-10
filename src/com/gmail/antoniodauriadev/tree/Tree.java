package com.gmail.antoniodauriadev.tree;

import com.gmail.antoniodauriadev.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.exceptions.tree.EmptyTreeException;

import java.util.Iterator;

public interface Tree<E> {

    /**@return The tree's size.*/
    int size();

    /**@return True if the tree is empty.*/
    boolean isEmpty();

    /**@return Tree's elements iterator.*/
    Iterator<E> iterator();

    /**@return a nodes' iterable collection.*/
    Iterable<Position<E>> positions();

    /**Overwrite the element in the chosed node.
     * @throws InvalidPositionException If the position is invalid.
     * @return The previous element. */
    E replace(Position<E> node, E element) throws InvalidPositionException;

    /**@throws EmptyTreeException If the tree is empty.
     * @return The tree's root.*/
    Position<E> root() throws EmptyTreeException;

    /**@throws InvalidPositionException If the position is invalid.
     * @throws BoundaryViolationException If the boundary will be violated.
     * @return The node's father.*/
    Position<E> parent(Position<E> node) throws InvalidPositionException, BoundaryViolationException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return Iterable collection of node's children.*/
    Iterable<Position<E>> children(Position<E> node) throws InvalidPositionException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return True if the chosen node is an internal node.*/
    boolean isInternal(Position<E> node) throws InvalidPositionException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return True if the chosen node is a leaf.*/
    boolean isExternal(Position<E> node) throws InvalidPositionException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return true if the chesen node is the root node.*/
    boolean isRoot(Position<E> node) throws InvalidPositionException;
}