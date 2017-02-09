package com.gmail.antoniodauriadev.positionlist;

import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.positionlist.exceptions.EmptyListException;
import com.gmail.antoniodauriadev.positionlist.exceptions.InvalidPositionException;

public interface PositionList<E> extends Iterable<E> {

    /**@return The position list's size.*/
    int size();

    /**@return True if the position list is empty.*/
    boolean isEmpty();

    /**@throws EmptyListException If the list is empty.
     * @return The first element's position.*/
    Position<E> first() throws EmptyListException;

    /**@throws EmptyListException If the list is empty.
     * @return The last element's position.*/
    Position<E> last() throws EmptyListException;

    /**@throws InvalidPositionException If the position is not in the list.
     * @throws BoundaryViolationException If the Boundary is violated.
     * @param p Position.
     * @return The next Position after the chosen.*/
    Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;

    /**@throws InvalidPositionException If the position is not in the list.
     * @throws BoundaryViolationException If the Boundary is violated.
     * @param p Position.
     * @return The previous Position before the chosen.*/
    Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException;

    /**Adds an element in the first position.
     * @param e Element to add.*/
    void addFirst(E e);

    /**Adds an element in the last position.
     * @param e Element to add.*/
    void addLast(E e);

    /**Adds an element after the chosen position.
     * @throws InvalidPositionException If the position is not in the list.
     * @param p Position.
     * @param e Element to add.*/
    void addAfter(Position<E> p, E e) throws InvalidPositionException;

    /**Adds an element before the chosen position.
     * @throws InvalidPositionException If the position is not in the list.
     * @param p Position.
     * @param e Element to add.*/
    void addBefore(Position<E> p, E e) throws InvalidPositionException;

    /**Removes the element in the chosen position.
     * @throws InvalidPositionException If the position is not in the list.
     * @param p Position.
     * @return Removed elment.*/
    E remove(Position<E> p) throws InvalidPositionException;

    /**Overwrites the element in the chosen position.
     * @throws InvalidPositionException If the position is not in the list.
     * @param p Position.
     * @return the old elment in that position..*/
    E set(Position<E> p, E e) throws InvalidPositionException;

}
