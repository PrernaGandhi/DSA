package com.dsa.graph.algorithms.sort.topological.v1;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
    String startVertexName;
    List<Vertex> adjVertices;
    int inDegree;

    Vertex(String startVertexName) {
        this.adjVertices = new LinkedList<>();
        this.startVertexName = startVertexName;
    }

    public List<Vertex> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Vertex vertex) {
        vertex.setInDegree(vertex.inDegree + 1);
        this.adjVertices.add(vertex);
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    @Override
    public String toString() {
        return startVertexName;
    }
}