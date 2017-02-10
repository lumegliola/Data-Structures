package com.gmail.antoniodauriadev.binarytree;

public class BinaryTreeNode<E> implements BinaryTreePosition<E> {

    private E element;
    private BinaryTreePosition<E> left, right, parent;


    public BinaryTreeNode(E element, BinaryTreePosition<E> left, BinaryTreePosition<E> right, BinaryTreePosition<E> parent) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    public E element() {
        return this.element;
    }

    @Override
    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public BinaryTreePosition<E> getLeft() {
        return this.left;
    }

    @Override
    public void setLeft(BinaryTreePosition<E> position) {
        this.left = position;
    }

    @Override
    public BinaryTreePosition<E> getRight() {
        return this.right;
    }

    @Override
    public void setRight(BinaryTreePosition<E> position) {
        this.right = position;
    }

    @Override
    public BinaryTreePosition<E> getParent() {
        return this.parent;
    }

    @Override
    public void setParent(BinaryTreePosition<E> position) {
        this.parent = position;
    }
}
