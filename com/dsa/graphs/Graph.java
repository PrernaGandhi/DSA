package com.dsa.graphs;

public interface Graph {

    void addEdge(Vertex v, Vertex w);

    Iterable<Edge> adj(Vertex v);

    Iterable<Edge> getEdges();

    Iterable<Vertex> geVertices();

    int numberOfVertices();

    int numberOfEdges();

    String toString();

    void printGraph();


}
