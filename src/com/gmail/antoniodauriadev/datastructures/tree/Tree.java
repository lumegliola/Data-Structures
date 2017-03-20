package com.gmail.antoniodauriadev.datastructures.tree;

import java.util.Iterator;

import com.gmail.antoniodauriadev.datastructures.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.datastructures.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.datastructures.exceptions.tree.EmptyTreeException;
import com.gmail.antoniodauriadev.datastructures.position.Position;

public interface Tree<E> {

    /**@return Size of the tree.*/
    int size();

    /**@return True if the tree is empty.*/
    boolean isEmpty();

    /**@return Elements iterator of the tree.*/
    Iterator<E> iterator();

    /**@return an iterable collection of the nodes.*/
    Iterable<Position<E>> positions();

    /**Overwrite the element in the chosen node.
     * @throws InvalidPositionException If the position is invalid.
     * @return Previous element. */
    E replace(Position<E> node, E element) throws InvalidPositionException;

    /**@throws EmptyTreeException If the tree is empty.
     * @return Root of the tree.*/
    Position<E> root() throws EmptyTreeException;

    /**@throws InvalidPositionException If the position is invalid.
     * @throws BoundaryViolationException If the boundary will be violated.
     * @return Parent of the node.*/
    Position<E> parent(Position<E> node) throws InvalidPositionException, BoundaryViolationException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return Iterable collection of the children of the node.*/
    Iterable<Position<E>> children(Position<E> node) throws InvalidPositionException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return True if the chosen node is an internal node.*/
    boolean isInternal(Position<E> node) throws InvalidPositionException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return True if the chosen node is a leaf.*/
    boolean isExternal(Position<E> node) throws InvalidPositionException;

    /**@throws InvalidPositionException If the position is invalid.
     * @return true if the chosen node is the root node.*/
    boolean isRoot(Position<E> node) throws InvalidPositionException;
}