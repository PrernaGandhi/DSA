package com.dsa.graph.algorithms.mst.prims;

public class Runner {
    public static void main(String[] args) {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");

        v0.addEdge(new Edge(4, v0, v1));
        v0.addEdge(new Edge(8, v0, v2));

        v1.addEdge(new Edge(2, v1, v2));
        v1.addEdge(new Edge(6, v1, v3));

        v2.addEdge(new Edge(3, v2, v3));
        v2.addEdge(new Edge(9, v2, v4));

        v3.addEdge(new Edge(5, v3, v4));

        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();
        primsAlgorithm.compute(v0);
    }
}
