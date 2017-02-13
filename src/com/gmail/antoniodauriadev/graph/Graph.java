package com.gmail.antoniodauriadev.graph;

import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;

public interface Graph<V, E> {

    /**@return The vertices' number.*/
    int numVertices();

    /**@return The edges' number.*/
    int numEdges();

    /**@return A vertices' iterable collection.*/
    Iterable<Vertex<V>> vertices();

    /**@return An edges' iterable collection.*/
    Iterable<Edge<E>> edges();

    /**Replaces the element of a given vertex with a new element.
     * @return The old element.*/
    V replace(Vertex<V> vertex, V element) throws InvalidPositionException;

    /**Replaces the element of a given edge with a new element.
     * @return The old element.*/
    E replace(Edge<E> edge, E element) throws InvalidPositionException;

    /**@return The edges incident on a vertex as an iterable collection.*/
    Iterable<Edge<E>> incidentEdges(Vertex<V> vertex) throws InvalidPositionException;

    /**@return The vertices of an edge as an array of length 2.*/
    Vertex[] endVertices(Edge<E> edge) throws InvalidPositionException;

    /**@return The other end vertex of an incident edge.*/
    Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) throws InvalidPositionException;

    /**@return True whether the two vertices are adjacent.*/
    boolean areAdjacent(Vertex<V> vertexA, Vertex<V> vertexB) throws InvalidPositionException;

    /**Inserts a new vertex with a given element.
     * @return A new vertex with a given element.*/
    Vertex<V> insertVertex(V element);

    /**Inserts a new edge with a given element between two vertices.
     * @return The added Edge:*/
    Edge<E> insertEdge(Vertex<V> vertexA, Vertex<V> vertexB, E element) throws InvalidPositionException;

    /**Removes a vertex and all its incident edges.
     * @return The element stored at the removed vertex.*/
    V removeVertex(Vertex<V> vertex) throws InvalidPositionException;

    /**Removes an edge.
     * @return its element*/
    E removeEdge(Edge<E> edge) throws InvalidPositionException;
}
