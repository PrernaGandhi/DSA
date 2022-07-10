package com.dsa.graph.algorithms.mst.kruskal;

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
        Vertex v6 = new Vertex("6");
        Vertex v7 = new Vertex("7");
        Vertex v8 = new Vertex("8");

        v0.addEdge(new Edge(v0, v1, 4));
        v0.addEdge(new Edge(v0, v7, 8));

        v1.addEdge(new Edge(v1, v2, 8));
        v1.addEdge(new Edge(v1, v7, 11));

        v2.addEdge(new Edge(v2, v3, 7));
        v2.addEdge(new Edge(v2, v5, 4));
        v2.addEdge(new Edge(v2, v8, 2));

        v3.addEdge(new Edge(v3, v4, 9));
        v3.addEdge(new Edge(v3, v5, 14));

        v4.addEdge(new Edge(v4, v5, 10));

        v5.addEdge(new Edge(v5, v6, 2));

        v6.addEdge(new Edge(v6, v7, 1));
        v6.addEdge(new Edge(v6, v8, 6));

        v7.addEdge(new Edge(v7, v8, 7));

        List<Vertex> graph = new ArrayList<>();
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);
        graph.add(v6);
        graph.add(v7);
        graph.add(v8);

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
        kruskalAlgorithm.algo(graph).forEach(edge -> System.out.print(edge + " "));
    }
}
