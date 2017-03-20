package com.gmail.antoniodauriadev.datastructures.tree;

import java.util.Iterator;

import com.gmail.antoniodauriadev.datastructures.exceptions.BoundaryViolationException;
import com.gmail.antoniodauriadev.datastructures.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.datastructures.exceptions.tree.EmptyTreeException;
import com.gmail.antoniodauriadev.datastructures.exceptions.tree.NonEmptyTreeException;
import com.gmail.antoniodauriadev.datastructures.position.Position;
import com.gmail.antoniodauriadev.datastructures.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.datastructures.positionlist.PositionList;

public class LinkedTree<E> implements Tree<E> {

    private TreePosition<E> root;
    private int size;

    public LinkedTree() {
        this.root = null;
        this.size = 0;
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
        TreePosition<E> checkedNode = checkPosition(node);
        E toReturn = checkedNode.element();
        checkedNode.setElement(element);
        return toReturn;
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        if (size() == 0)
            throw new EmptyTreeException();
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> node) throws InvalidPositionException, BoundaryViolationException {
        TreePosition<E> checkedNode = checkPosition(node);

        if(checkedNode == this.root)
            throw new  BoundaryViolationException("The root node don't has a parent.");

        return checkedNode.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> node) throws InvalidPositionException {
        TreePosition<E> checkedNode = checkPosition(node);
        if (isExternal(node))
            throw new InvalidPositionException("A leaf don't has children.");
        return checkedNode.getChildren();
    }

    @Override
    public boolean isInternal(Position<E> node) throws InvalidPositionException {
        return !isExternal(node);
    }

    @Override
    public boolean isExternal(Position<E> node) throws InvalidPositionException {
        TreePosition<E> checkednode = checkPosition(node);
        return (checkednode.getChildren() == null) || checkednode.getChildren().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> node) throws InvalidPositionException {
        return checkPosition(node) == root;
    }

    /**Casts Position to TreePosition if possible.
     * @param node Node to cast.
     * @return Casted node.*/
    private TreePosition<E> checkPosition(Position<E> node) throws InvalidPositionException {

        if (node == null || !(node instanceof TreePosition))
            throw new InvalidPositionException("The position is not valid.");
        return (TreePosition<E>) node;
    }

    /**Creates a list storing the nodes in the subtree of a node,
     *ordered according to the preorder traversal of the subtree.*/
    private void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
        checkPosition(v);
        pos.addLast(v);
        if (isInternal(v))
            for (Position<E> w : children(v))
                preorderPositions(w, pos);
    }

    /**Insert a child*/
    public Position<E> insertChild(Position<E> position, E element) throws InvalidPositionException {
        TreePosition<E> checkedPosition = checkPosition(position);
        TreePosition<E> nodeToAdd = createNode(element,checkedPosition,null);
        PositionList<Position<E>> children = checkedPosition.getChildren();
        if(children == null){
            children = new NodePositionList<>();
            checkedPosition.setChildren(children);
        }
        children.addLast(nodeToAdd);
        size++;
        return nodeToAdd;
    }

    /**Adds a root node to an empty tree.*/
    public Position<E> addRoot(E e) throws NonEmptyTreeException {
        if(!isEmpty())
            throw new NonEmptyTreeException("Tree already has a root.");
        size = 1;
        root = createNode(e,null,null);
        return root;
    }

    /**Creates a new tree node.*/
    private TreePosition<E> createNode(E element, TreePosition<E> parent, PositionList<Position<E>> children) {
        return new TreeNode<>(element,parent,children);
    }

}