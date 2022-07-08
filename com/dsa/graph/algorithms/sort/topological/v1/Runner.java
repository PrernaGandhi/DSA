package com.dsa.graph.algorithms.sort.topological.v1;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        v0.setAdjVertices(v3);
        v1.setAdjVertices(v2);
        v2.setAdjVertices(v4);
        v3.setAdjVertices(v4);
        v3.setAdjVertices(v5);
        v4.setAdjVertices(v5);

        List<Vertex> graph = new ArrayList<>();
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        for (Vertex v : graph) {
            System.out.println(v + " [in-degree = " + v.inDegree + "]");
        }

        TopologicalSort topologicalSort = new TopologicalSort();
        System.out.print("Topological Order : ");
        topologicalSort.getTopologicalOrder(graph).forEach(vertex -> System.out.print(vertex + " "));
    }
}
