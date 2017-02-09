package com.gmail.antoniodauriadev.tree;

import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.PositionList;

public class TreeNode<E> implements TreePosition<E> {

    private E element;
    private TreePosition<E> parent;
    private PositionList<Position<E>> children;


    public TreeNode(E element, TreePosition<E> parent, PositionList<Position<E>> children) {
        setElement(element);
        setParent(parent);
        setChildren(children);
    }

    public TreeNode() {
        this(null,null,null);
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
    public PositionList<Position<E>> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(PositionList<Position<E>> children) {
        this.children = children;
    }

    @Override
    public TreePosition<E> getParent() {
        return this.parent;
    }

    @Override
    public void setParent(TreePosition<E> parentPosition) {
        this.parent = parentPosition;
    }
}
