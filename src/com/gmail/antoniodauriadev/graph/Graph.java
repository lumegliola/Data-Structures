package com.gmail.antoniodauriadev.graph;

import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;

public interface Graph<V, E> {

    /**@return Number of the vertices.*/
    int numVertices();

    /**@return Number of the edges.*/
    int numEdges();

    /**@return An iterable collection of the vertices.*/
    Iterable<Vertex<V>> vertices();

    /**@return An iterable collection of the edges.*/
    Iterable<Edge<E>> edges();

    /**Replaces the element of a given vertex with a new element.
     * @return Old element.*/
    V replace(Vertex<V> vertex, V element) throws InvalidPositionException;

    /**Replaces the element of a given edge with a new element.
     * @return Old element.*/
    E replace(Edge<E> edge, E element) throws InvalidPositionException;

    /**@return Edges incident on a vertex as an iterable collection.*/
    Iterable<Edge<E>> incidentEdges(Vertex<V> vertex) throws InvalidPositionException;

    /**@return Vertices of an edge as an array of length 2.*/
    Vertex[] endVertices(Edge<E> edge) throws InvalidPositionException;

    /**@return Other end vertex of an incident edge.*/
    Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) throws InvalidPositionException;

    /**@return True whether the two vertices are adjacent.*/
    boolean areAdjacent(Vertex<V> vertexA, Vertex<V> vertexB) throws InvalidPositionException;

    /**Inserts a new vertex with a given element.
     * @return Added vertex.*/
    Vertex<V> insertVertex(V element);

    /**Inserts a new edge with a given element between two vertices.
     * @return Added edge.*/
    Edge<E> insertEdge(Vertex<V> vertexA, Vertex<V> vertexB, E element) throws InvalidPositionException;

    /**Removes a vertex and all its incident edges.
     * @return Element stored at the removed vertex.*/
    V removeVertex(Vertex<V> vertex) throws InvalidPositionException;

    /**Removes an edge.
     * @return its element*/
    E removeEdge(Edge<E> edge) throws InvalidPositionException;
}
