package com.dsa.graph.algorithms.cycle_detection;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Vertex vertex0 = new Vertex("A");
        Vertex vertex1 = new Vertex("B");
        Vertex vertex2 = new Vertex("C");
        Vertex vertex3 = new Vertex("D");
        Vertex vertex4 = new Vertex("E");
        Vertex vertex5 = new Vertex("F");

        vertex5.addNeighbour(vertex0);

        vertex0.addNeighbour(vertex4);
        vertex0.addNeighbour(vertex2);

        // this is point of cycle creation, if we comment it out
        // we can test for no cycle use-case
        vertex4.addNeighbour(vertex5);

        vertex2.addNeighbour(vertex1);
        vertex2.addNeighbour(vertex3);

        List<Vertex> graph = new ArrayList<>();
        graph.add(vertex0);
        graph.add(vertex1);
        graph.add(vertex2);
        graph.add(vertex3);
        graph.add(vertex4);
        graph.add(vertex5);

        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.detectCycles(graph);
    }
}