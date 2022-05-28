package com.dsa.graph.algorithms.shortest_distance;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private List<Edge> adjacencyList;
    // shortest path from the source vertex
    private int minDistance;
    // track previous node in the shortest path
    private Vertex predecessor;

    public Vertex(String name) {
        this.name = name;
        this.minDistance = Integer.MAX_VALUE;
        this.adjacencyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getEdges() {
        return adjacencyList;
    }

    public void addEdge(Edge edge) {
        this.adjacencyList.add(edge);
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return name + " - " + predecessor;
    }
}
