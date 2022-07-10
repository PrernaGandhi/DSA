package com.dsa.graph.algorithms.mst.kruskal;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String node;
    private List<Edge> adjList;
    private Vertex parent;

    public Vertex(String name) {
        this.node = name;
        this.adjList = new ArrayList<>();
    }

    public List<Edge> getAdjList() {
        return adjList;
    }

    public void addEdge(Edge edge) {
        this.adjList.add(edge);
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return node;
    }
}
