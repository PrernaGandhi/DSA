package com.dsa.graph.algorithms.shortest_distance.using_dijkstra;

public class Edge {
    private Vertex startVertex;
    private Vertex targetVertex;
    private int weight;

    public Edge(Vertex startVertex, Vertex targetVertex, int weight) {
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public int getWeight() {
        return weight;
    }
}
