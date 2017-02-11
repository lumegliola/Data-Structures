package com.gmail.antoniodauriadev.completebinarytree;

import com.gmail.antoniodauriadev.arraylist.ArrayIndexList;
import com.gmail.antoniodauriadev.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.exceptions.tree.EmptyTreeException;
import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;

import java.util.Iterator;

public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E> {

    private ArrayIndexList<CompleteBinaryTreeNode<E>> T;

    public ArrayListCompleteBinaryTree() {
        T = new ArrayIndexList<>();
        T.add(0, null); // the location at rank 0 is deliberately empty
    }

    @Override
    public Position<E> add(E element) {
        int i = size() + 1;
        CompleteBinaryTreeNode<E> p = new CompleteBinaryTreeNode<>(element,i);
        T.add(i, p);
        return p;
    }

    @Override
    public E remove() {
        if(isEmpty()) throw new EmptyTreeException("Tree is empty.");
        return T.remove(size()).element();
    }

    @Override
    public Position<E> left(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
        if (!hasLeft(position))
            throw new BoundaryViolationException("No left child.");
        CompleteBinaryTreeNode<E> checkedNode = checkPosition(position);
        return T.get(2*checkedNode.index());
    }

    @Override
    public Position<E> right(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
        if (!hasRight(position))
            throw new BoundaryViolationException("No right child.");
        CompleteBinaryTreeNode<E> checkedNode = checkPosition(position);
        return T.get(2*checkedNode.index() + 1);
    }

    @Override
    public boolean hasLeft(Position<E> position) throws InvalidPositionException {
        CompleteBinaryTreeNode<E> checkedNode = checkPosition(position);
        return 2*checkedNode.index() <= size();
    }

    @Override
    public boolean hasRight(Position<E> position) throws InvalidPositionException {
        CompleteBinaryTreeNode<E> checkedNode = checkPosition(position);
        return 2*checkedNode.index() + 1 <= size();
    }

    @Override
    public int size() {
        return T.size() - 1;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Iterator<E> iterator() {
        PositionList<E> elements = new NodePositionList<>();
        for (int i = 1; i < T.size(); i++)
            elements.addLast(T.get(i).element());
        return elements.iterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> positions = new NodePositionList<>();
        for (int i =1; i < T.size(); i++)
            positions.addLast(T.get(i));
        return positions;
    }

    @Override
    public E replace(Position<E> node, E element) throws InvalidPositionException {
        CompleteBinaryTreeNode<E> checkedNode = checkPosition(node);
        E previousElement = checkedNode.element();
        checkedNode.setElement(element);
        return previousElement;
    }


    @Override
    public Position<E> root() throws EmptyTreeException {
        if (isEmpty())
            throw new EmptyTreeException();
        return T.get(1);
    }

    @Override
    public Position<E> parent(Position<E> node) throws InvalidPositionException, BoundaryViolationException {
        if (isRoot(node)) throw new BoundaryViolationException("No parent.");
        CompleteBinaryTreeNode<E> checkedNode = checkPosition(node);
        return T.get(checkedNode.index()/2);
    }

    @Override
    public Iterable<Position<E>> children(Position<E> node) throws InvalidPositionException {
        PositionList<Position<E>> children = new NodePositionList<>();
        if (hasLeft(node))
            children.addLast(left(node));
        if (hasRight(node))
            children.addLast(right(node));
        return children;
    }

    @Override
    public boolean isInternal(Position<E> node) throws InvalidPositionException {
        return hasLeft(node);
    }

    @Override
    public boolean isExternal(Position<E> node) throws InvalidPositionException {
        return !isInternal(node);
    }

    @Override
    public boolean isRoot(Position<E> node) throws InvalidPositionException {
        CompleteBinaryTreeNode<E> checkedNode = checkPosition(node);
        return checkedNode.index() == 1;
    }

    /** Determines whether the given position is a valid node. */
    private CompleteBinaryTreeNode<E> checkPosition(Position<E> v) throws InvalidPositionException
    {
        if (v == null || !(v instanceof CompleteBinaryTreeNode))
            throw new InvalidPositionException("Position is invalid");
        return (CompleteBinaryTreeNode<E>) v;
    }
}
