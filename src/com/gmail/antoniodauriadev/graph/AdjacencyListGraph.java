package com.gmail.antoniodauriadev.graph;

import com.gmail.antoniodauriadev.exceptions.InvalidPositionException;
import com.gmail.antoniodauriadev.map.HashTableMap;
import com.gmail.antoniodauriadev.position.Position;
import com.gmail.antoniodauriadev.positionlist.NodePositionList;
import com.gmail.antoniodauriadev.positionlist.PositionList;

public class AdjacencyListGraph<V, E> implements Graph<V, E> {

    private NodePositionList<Vertex<V>> vertices;
    private NodePositionList<Edge<E>> edges;


    @Override
    public int numVertices() {
        return this.vertices.size();
    }

    @Override
    public int numEdges() {
        return this.edges.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return this.vertices;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return this.edges;
    }

    @Override
    public V replace(Vertex<V> vertex, V element) throws InvalidPositionException {
        MyVertex<V> checkedVertex = checkVertex(vertex);
        V prevElement = checkedVertex.element();
        checkedVertex.setElement(element);
        return prevElement;
    }

    @Override
    public E replace(Edge<E> edge, E element) throws InvalidPositionException {
        MyEdge<E> checkedEdge = checkEdge(edge);
        E prevElement = checkedEdge.element();
        checkedEdge.setElement(element);
        return prevElement;
    }

    @Override
    public Iterable<Edge<E>> incidentEdges(Vertex<V> vertex) throws InvalidPositionException {
        return checkVertex(vertex).incidentEdges();
    }

    @Override
    public Vertex[] endVertices(Edge<E> edge) throws InvalidPositionException {
        return checkEdge(edge).endVertices();
    }

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
        Iterable<Edge<E>> iterToSearch;
        if(degree(vertexA) < degree(vertexB))
            iterToSearch = incidentEdges(vertexA);
        else
            iterToSearch = incidentEdges(vertexB);
        for (Edge<E> e: iterToSearch){
            Vertex<V>[] endV = endVertices(e);
            if ((endV[0]==vertexA && endV[1]==vertexB) || (endV[0])==vertexB && endV[1]==vertexA)
                return true;
        }
        return false;
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        MyVertex<V> toInsert =  new MyVertex<>(element);
        this.vertices.addLast(toInsert);
        Position<Vertex<V>> p = this.vertices.last();
        toInsert.setLocation(p);
        return toInsert;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> vertexA, Vertex<V> vertexB, E element) throws InvalidPositionException {
        MyVertex<V> checkedVertexA = checkVertex(vertexA);
        MyVertex<V> checkedVertexB = checkVertex(vertexB);
        MyEdge<E> toInsert = new MyEdge<>(vertexA, vertexB, element);
        Position<Edge<E>> pVertexA = checkedVertexA.insertIncidence(toInsert);
        Position<Edge<E>> pVertexB = checkedVertexB.insertIncidence(toInsert);
        toInsert.setIncidences(pVertexA, pVertexB);
        this.edges.addLast(toInsert);
        Position<Edge<E>> pe = this.edges.last();
        toInsert.setLocation(pe);
        return toInsert;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) throws InvalidPositionException {
        MyVertex<V> vv = checkVertex(vertex);
        Iterable<Edge<E>> iterToSearch = incidentEdges(vertex);
        for (Edge<E> e : iterToSearch)
            if (((MyEdge<E>)e).location() != null) // if the edge has not been marked invalid
                removeEdge(e);
        this.vertices.remove(vv.location());
        return vertex.element();
    }

    @Override
    public E removeEdge(Edge<E> edge) throws InvalidPositionException {
        MyEdge<E> checkedEdge = checkEdge(edge);
        MyVertex<V>[] endVertices = checkedEdge.endVertices();
        Position<Edge<E>>[] inc = checkedEdge.incidences();
        endVertices[0].removeIncidence(inc[0]);
        endVertices[1].removeIncidence(inc[1]);
        edges.remove(checkedEdge.location());
        checkedEdge.setLocation(null);	// invalidating this edge
        return edge.element();
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

    private int degree(Vertex<V> vertex) throws InvalidPositionException {
        MyVertex<V> checkedVertex = checkVertex(vertex);
        return checkedVertex.degree();
    }

    /**Implementation of a decorable position by means of a hash table.*/
    private static class MyPosition<T> extends HashTableMap<Object,Object> implements DecorablePosition<T> {
        private T element;

        /**@return The element stored at this position.*/
        public T element() {
            return this.element;
        }

        /** Sets the element stored at this position.*/
        void setElement(T element) {
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
        int degree() {
            return incEdges.size();
        }

        /** Returns the incident edges on this vertex. */
        Iterable<Edge<E>> incidentEdges() {
            return incEdges;
        }

        /** Inserts an edge into the incidence container of this vertex. */
        Position<Edge<E>> insertIncidence(Edge<E> e) {
            incEdges.addLast(e);
            return incEdges.last();
        }

        /** Removes an edge from the incidence container of this vertex. */
        void removeIncidence(Position<Edge<E>> p) {
            incEdges.remove(p);
        }

        /** Returns the position of this vertex in the vertex container of
         * the graph. */
        Position<Vertex<V>> location() {
            return loc;
        }

        /** Sets the position of this vertex in the vertex container of
         * the graph. */
        void setLocation(Position<Vertex<V>> p) {
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
    private class MyEdge<E> extends MyPosition<E> implements Edge<E> {

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
        MyVertex<V>[] endVertices() {
            return endVertices;
        }

        /** Returns the positions of the edge in the incidence containers
         * of its end vertices.  The returned array always contains two
         * elements. */
        Position<Edge<E>>[] incidences() {
            return Inc;
        }

        /** Sets the positions of the edge in the incidence containers of
         * its end vertices. */
        void setIncidences(Position<Edge<E>> pv, Position<Edge<E>> pw) {
            Inc[0] = pv;
            Inc[1] = pw;
        }

        /** Returns the position of the edge in the edge container of the
         * graph. */
        Position<Edge<E>> location() {
            return loc;
        }

        /** Sets the position of the edge in the edge container of the
         * graph. */
        void setLocation(Position<Edge<E>> p) {
            loc = p;
        }

        /** Returns a string representation of the edge via a tuple of
         * vertices. */
        public String toString() {
            return "(" + endVertices[0].toString() + "," + endVertices[1].toString() + ")";
        }
    }

}