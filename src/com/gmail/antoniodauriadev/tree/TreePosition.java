package com.gmail.antoniodauriadev.tree;

import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.PositionList;

interface TreePosition<E> extends Position<E> {

    /**Sets the element.
     * @param element Element to set.*/
    void setElement(E element);

    /**@return A children's position list.*/
    PositionList<Position<E>> getChildren();

    /**Sets the node's children.
     * @param children Children's position list.*/
    void setChildren(PositionList<Position<E>> children);

    /**@return The node's parent.*/
    TreePosition<E> getParent();

    /**Sets the node's parent.
     * @param parentPosition Parent's position.*/
    void setParent(TreePosition<E> parentPosition);
}