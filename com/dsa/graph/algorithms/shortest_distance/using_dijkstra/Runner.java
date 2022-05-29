package com.dsa.graph.algorithms.shortest_distance.using_dijkstra;

public class Runner {
    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");
        Vertex v4 = new Vertex("E");
        Vertex v5 = new Vertex("F");
        Vertex v6 = new Vertex("G");
        Vertex v7 = new Vertex("H");

        v0.addEdge(new Edge(v0, v1,5));
        v0.addEdge(new Edge(v0, v4,9));
        v0.addEdge(new Edge(v0, v7,8));

        v1.addEdge(new Edge(v1, v2, 12));
        v1.addEdge(new Edge(v1, v3, 15));
        v1.addEdge(new Edge(v1, v7, 4));

        v2.addEdge(new Edge(v2, v3, 3));
        v2.addEdge(new Edge(v2, v6, 11));

        v3.addEdge(new Edge(v3, v6, 9));

        v4.addEdge(new Edge(v4, v5, 4));
        v4.addEdge(new Edge(v4, v6, 20));
        v4.addEdge(new Edge(v4, v7, 5));

        v5.addEdge(new Edge(v5, v2, 1));
        v5.addEdge(new Edge(v5, v7, 13));

        v7.addEdge(new Edge(v7, v2, 7));
        v7.addEdge(new Edge(v7, v5, 6));

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        algorithm.computePath(v0);

        System.out.println(algorithm.getShortestPathTo(v0));
        System.out.println(algorithm.getShortestPathTo(v1));
        System.out.println(algorithm.getShortestPathTo(v2));
        System.out.println(algorithm.getShortestPathTo(v3));
        System.out.println(algorithm.getShortestPathTo(v4));
        System.out.println(algorithm.getShortestPathTo(v5));
        System.out.println(algorithm.getShortestPathTo(v6));
        System.out.println(algorithm.getShortestPathTo(v7));

    }
}
