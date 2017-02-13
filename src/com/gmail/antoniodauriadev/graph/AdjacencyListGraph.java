package com.gmail.antoniodauriadev.graph;

import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.map.HashTableMap;
import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;

public class AdjacencyListGraph<V, E> implements Graph<V, E> {

    private NodePositionList<Vertex<V>> vertices;
    private NodePositionList<Edge<E>> edges;

//
    @Override
    public int numVertices() {
        return this.vertices.size();
    }
//
    @Override
    public int numEdges() {
        return this.edges.size();
    }
//
    @Override
    public Iterable<Vertex<V>> vertices() {
        return this.vertices;
    }
//
    @Override
    public Iterable<Edge<E>> edges() {
        return this.edges;
    }
//
    @Override
    public V replace(Vertex<V> vertex, V element) throws InvalidPositionException {
        MyVertex<V> checkedVertex = checkVertex(vertex);
        V prevElement = checkedVertex.element();
        checkedVertex.setElement(element);
        return prevElement;
    }
//
    @Override
    public E replace(Edge<E> edge, E element) throws InvalidPositionException {
        MyEdge<E> checkedEdge = checkEdge(edge);
        E prevElement = checkedEdge.element();
        checkedEdge.setElement(element);
        return prevElement;
    }
//
    @Override
    public Iterable<Edge<E>> incidentEdges(Vertex<V> vertex) throws InvalidPositionException {
        return checkVertex(vertex).incidentEdges();
    }
//
    @Override
    public Vertex[] endVertices(Edge<E> edge) throws InvalidPositionException {
        return checkEdge(edge).endVertices();
    }
//
    @Override
    public Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) throws InvalidPositionException {
        checkVertex(vertex);
        MyEdge<E> checkedEdge = checkEdge(edge);
        Vertex<V>[] endVertex = checkedEdge.endVertices();
        if (vertex == endVertex[0])
            return endVertex[1];
        else if (vertex == endVertex[1])
            return endVertex[0];
        else
            throw new InvalidPositionException("No such vertex exists.");
    }

    @Override
    public boolean areAdjacent(Vertex<V> vertexA, Vertex<V> vertexB) throws InvalidPositionException {
        return false;
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        return null;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> vertexA, Vertex<V> vertexB, E element) throws InvalidPositionException {
        return null;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) throws InvalidPositionException {
        return null;
    }

    @Override
    public E removeEdge(Edge<E> edge) throws InvalidPositionException {
        return null;
    }

    private MyVertex<V> checkVertex(Vertex<V> vertex) {
        if (vertex instanceof MyVertex) {
            return (MyVertex<V>) vertex;
        } else throw new InvalidPositionException("The given vertex is invalid.");
    }

    private MyEdge<E> checkEdge(Edge<E> edge) {
        if (edge instanceof MyEdge) {
            return (MyEdge<E>) edge;
        } else throw new InvalidPositionException("The given edge is invalid.");
    }

    /**Implementation of a decorable position by means of a hash table.*/
    private static class MyPosition<T> extends HashTableMap<Object,Object> implements DecorablePosition<T> {
        private T element;

        /**@return The element stored at this position.*/
        public T element() {
            return this.element;
        }
        /** Sets the element stored at this position.*/
        public void setElement(T element) {
            this.element = element;
        }
    }

    /**Implementation of a vertex for an undirected adjacency list
     * graph.  Each vertex stores its incidence container and position
     * in the vertex container of the graph.*/
    private class MyVertex<V> extends MyPosition<V> implements Vertex<V> {

        /** Incidence container of the vertex. */
        private PositionList<Edge<E>> incEdges;

        /** Position of the vertex in the vertex container of the graph. */
        private Position<Vertex<V>> loc;

        /** Constructs the vertex with the given element. */
        MyVertex(V o) {
            setElement(o);
            incEdges = new NodePositionList<>();
        }
        /** Return the degree of a given vertex */
        public int degree() {
            return incEdges.size();
        }
        /** Returns the incident edges on this vertex. */
        public Iterable<Edge<E>> incidentEdges() {
            return incEdges;
        }
        /** Inserts an edge into the incidence container of this vertex. */
        public Position<Edge<E>> insertIncidence(Edge<E> e) {
            incEdges.addLast(e);
            return incEdges.last();
        }
        /** Removes an edge from the incidence container of this vertex. */
        public void removeIncidence(Position<Edge<E>> p) {
            incEdges.remove(p);
        }
        /** Returns the position of this vertex in the vertex container of
         * the graph. */
        public Position<Vertex<V>> location() {
            return loc;
        }
        /** Sets the position of this vertex in the vertex container of
         * the graph. */
        public void setLocation(Position<Vertex<V>> p) {
            loc = p;
        }
        /** Returns a string representation of the element stored at this
         * vertex. */
        public String toString() {
            return element().toString();
        }
    }

    /**Implementation of an edge for an undirected adjacency list
     * graph.  Each edge stores its endpoints (end vertices), its
     * positions within the incidence containers of its endpoints, and
     * position in the edge container of the graph.*/
    protected class MyEdge<E> extends MyPosition<E> implements Edge<E> {

        /** The end vertices of the edge. */
        private MyVertex<V>[] endVertices;
        /** The positions of the entries for the edge in the incidence
         * containers of the end vertices. */
        private Position<Edge<E>>[] Inc;
        /** The position of the edge in the edge container of the
         * graph. */
        private Position<Edge<E>> loc;

        /** Constructs an edge with the given endpoints and elements. */
        MyEdge (Vertex<V> v, Vertex<V> w, E o) {
            setElement(o);
            endVertices = (MyVertex<V>[]) new MyVertex[2];
            endVertices[0] = (MyVertex<V>)v;
            endVertices[1] = (MyVertex<V>)w;
            Inc = (Position<Edge<E>>[]) new Position[2];
        }
        /** Returns the end vertices of the edge. There are always two
         * elements in the returned array. */
        public MyVertex<V>[] endVertices() {
            return endVertices;
        }
        /** Returns the positions of the edge in the incidence containers
         * of its end vertices.  The returned array always contains two
         * elements. */
        public Position<Edge<E>>[] incidences() {
            return Inc;
        }
        /** Sets the positions of the edge in the incidence containers of
         * its end vertices. */
        public void setIncidences(Position<Edge<E>> pv, Position<Edge<E>> pw) {
            Inc[0] = pv;
            Inc[1] = pw;
        }
        /** Returns the position of the edge in the edge container of the
         * graph. */
        public Position<Edge<E>> location() {
            return loc;
        }
        /** Sets the position of the edge in the edge container of the
         * graph. */
        public void setLocation(Position<Edge<E>> p) {
            loc = p;
        }
        /** Returns a string representation of the edge via a tuple of
         * vertices. */
        public String toString() {
            return "(" + endVertices[0].toString() + "," + endVertices[1].toString() + ")";
        }
    }

}