package com.dsa.graph.algorithms.shortest_distance.using_dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private String name;
    private boolean isVisited;
    private int minDistance;
    private List<Edge> neighbours;
    // previous vertex on the shortest path
    private Vertex predecessors;

    public Vertex(String name) {
        this.name = name;
        this.minDistance = Integer.MAX_VALUE;
        this.neighbours = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public List<Edge> getNeighbours() {
        return neighbours;
    }

    public void addEdge(Edge edge) {
        this.neighbours.add(edge);
    }

    public Vertex getPredecessor() {
        return predecessors;
    }

    public void setPredecessors(Vertex predecessors) {
        this.predecessors = predecessors;
    }

    @Override
    public int compareTo(Vertex vertex) {
        return Double.compare(this.minDistance, vertex.getMinDistance());
    }

    @Override
    public String toString() {
        return name + " - " + minDistance;
    }
}
