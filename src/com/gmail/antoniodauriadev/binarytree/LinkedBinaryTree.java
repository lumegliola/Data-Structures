package com.gmail.antoniodauriadev.binarytree;

import com.gmail.antoniodauriadev.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.exceptions.tree.EmptyTreeException;
import com.gmail.antoniodauriadev.exceptions.tree.NonEmptyTreeException;
import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;

import java.util.Iterator;

public class LinkedBinaryTree<E> implements BinaryTree<E> {

    private BinaryTreePosition<E> root;
    private int size;

    /**Creates an empty LinkedBinaryTree.*/
    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    @Override
    public Position<E> left(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
        if (hasLeft(position)) {
            BinaryTreePosition<E> checkedPosition = checkPosition(position);
            return checkedPosition.getLeft();
        }
        else
            throw new BoundaryViolationException("The left child not exist.");
    }

    @Override
    public Position<E> right(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
        if (hasRight(position)) {
            BinaryTreePosition<E> checkedPosition = checkPosition(position);
            return checkedPosition.getRight();
        }
        else
            throw new BoundaryViolationException("The right child not exist.");
    }

    @Override
    public boolean hasLeft(Position<E> position) throws InvalidPositionException {
        BinaryTreePosition<E> tmp = checkPosition(position);
        return (tmp.getLeft() != null);
    }

    @Override
    public boolean hasRight(Position<E> position) throws InvalidPositionException {
        BinaryTreePosition<E> tmp = checkPosition(position);
        return (tmp.getRight() != null);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        Iterable<Position<E>> positions = positions();
        PositionList<E> elements = new NodePositionList<>();
        for (Position<E> pos: positions)
            elements.addLast(pos.element());
        return elements.iterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> positions = new NodePositionList<>();
        if(size != 0)
            preorderPositions(root(), positions);
        return positions;
    }

    @Override
    public E replace(Position<E> node, E element) throws InvalidPositionException {
        BinaryTreePosition<E> checkedPosition = checkPosition(node);
        E prevElement = checkedPosition.element();
        checkedPosition.setElement(element);
        return prevElement;
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        if (isEmpty())
            throw new EmptyTreeException();

        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> node) throws InvalidPositionException, BoundaryViolationException {
        BinaryTreePosition<E> checkedNode = checkPosition(node);
        if (checkedNode == this.root)
            throw new BoundaryViolationException("The root node doesn't have a parent.");

        return checkedNode.getParent();
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
        checkPosition(node);
        return (hasLeft(node) || hasRight(node));
    }

    @Override
    public boolean isExternal(Position<E> node) throws InvalidPositionException {
        return !isInternal(node);
    }

    @Override
    public boolean isRoot(Position<E> node) throws InvalidPositionException {
        checkPosition(node);
        return (node == root);
    }

    /**Adds a root if the tree is empty.*/
    public Position<E> addRoot(E e) throws NonEmptyTreeException {
        if(!isEmpty())
            throw new NonEmptyTreeException("The tree already have a root node.");
        size = 1;
        root = new BinaryTreeNode<>(e,null,null,null);
        return root;
    }

    /**Adds a left child at the chosed node.*/
    public Position<E> insertLeft(Position<E> position, E element) throws InvalidPositionException {
        BinaryTreePosition<E> checkedPosition = checkPosition(position);
        Position<E> leftPos = checkedPosition.getLeft();
        if (leftPos != null)
            throw new InvalidPositionException("The node already had a left child.");

        BinaryTreePosition<E> toAdd = new BinaryTreeNode<>(element, checkedPosition, null, null);
        checkedPosition.setLeft(toAdd);
        size++;
        return toAdd;
    }

    /**Adds a right child at the chosed node.*/
    public Position<E> insertRight(Position<E> position, E element) throws InvalidPositionException {
        BinaryTreePosition<E> checkedPosition = checkPosition(position);
        Position<E> rightPos = checkedPosition.getRight();
        if (rightPos != null)
            throw new InvalidPositionException("The node already had a right child.");

        BinaryTreePosition<E> toAdd = new BinaryTreeNode<>(element, checkedPosition, null, null);
        checkedPosition.setRight(toAdd);
        size++;
        return toAdd;
    }

    /**Removes a node with 0 or 1 child.
     * @return Removed element.*/
    public E remove(Position<E> nodeToRemove) throws InvalidPositionException {
        BinaryTreePosition<E> checkedNodeToRemove = checkPosition(nodeToRemove);
        BinaryTreePosition<E> leftPos = checkedNodeToRemove.getLeft();
        BinaryTreePosition<E> rightPos = checkedNodeToRemove.getRight();

        if (leftPos != null && rightPos != null)
            throw new InvalidPositionException("Can't remove a node with two children.");

        BinaryTreePosition<E> child;
        if (leftPos != null)
            child = leftPos;
        else if (rightPos != null)
            child = rightPos;
        else // ... nodeToRemove is a leaf
            child = null;

        if (checkedNodeToRemove == root) {
            if (child != null)
                child.setParent(null);
            root = child;
        }
        else {
            BinaryTreePosition<E> parent = checkedNodeToRemove.getParent();
            if (checkedNodeToRemove == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
            if(child != null)
                child.setParent(parent);
        }
        size--;
        return nodeToRemove.element();
    }

    private BinaryTreePosition<E> checkPosition(Position<E> v) throws InvalidPositionException {
        if (v == null || !(v instanceof BinaryTreePosition))
            throw new InvalidPositionException("The position is invalid");
        return (BinaryTreePosition<E>) v;
    }

    private void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
        pos.addLast(v);
        if (hasLeft(v))
            preorderPositions(left(v), pos); // recurse on left child
        if (hasRight(v))
            preorderPositions(right(v), pos); // recurse on right child
    }

}