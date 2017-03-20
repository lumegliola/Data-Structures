package com.gmail.antoniodauriadev.datastructures.tree;

import com.gmail.antoniodauriadev.datastructures.position.Position;
import com.gmail.antoniodauriadev.datastructures.positionlist.PositionList;

interface TreePosition<E> extends Position<E> {

    /**Sets the element.
     * @param element Element to set.*/
    void setElement(E element);

    /**@return Position list of the children.*/
    PositionList<Position<E>> getChildren();

    /**Sets the children of the node.
     * @param children Position list of the children.*/
    void setChildren(PositionList<Position<E>> children);

    /**@return Parent of the node.*/
    TreePosition<E> getParent();

    /**Sets the parent of the node.
     * @param parentPosition Position of the parent.*/
    void setParent(TreePosition<E> parentPosition);
}