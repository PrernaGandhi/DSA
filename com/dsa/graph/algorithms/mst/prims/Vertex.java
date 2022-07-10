package com.dsa.graph.algorithms.mst.prims;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String node;
    private boolean isVisited;
    private List<Edge> adjList;
    private Vertex parent;
    private int minDistance;

    public Vertex(String node) {
        this.node = node;
        this.minDistance = Integer.MAX_VALUE;
        this.adjList = new ArrayList<>();
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
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

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    @Override
    public String toString() {
        return node + " , minDist " + minDistance + " parent " + parent;
    }
}
