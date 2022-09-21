package com.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    boolean isVisited;
    private String name;
    private List<Edge> adjacentEdges;
    private int inDegree;
    private Vertex parentVertex;

    public Vertex(String name) {
        this.name = name;
        this.adjacentEdges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public void addEdge(Edge edge) {
        adjacentEdges.add(edge);
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex getParentVertex() {
        return parentVertex;
    }

    public void setParentVertex(Vertex parentVertex) {
        this.parentVertex = parentVertex;
    }

    @Override
    public String toString() {
        return name;
    }
}
