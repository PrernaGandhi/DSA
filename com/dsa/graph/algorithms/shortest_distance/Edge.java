package com.dsa.graph.algorithms.shortest_distance;

public class Edge {
    private Vertex target;
    private int weight;

    public Edge(Vertex target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
