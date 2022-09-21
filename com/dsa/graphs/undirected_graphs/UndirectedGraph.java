package com.dsa.graphs.undirected_graphs;

import com.dsa.graphs.Edge;
import com.dsa.graphs.Graph;
import com.dsa.graphs.Vertex;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
              1   2
              |  /
              | /
              0 ------ 6
              |        |
              |        |
              5 ------ 4
                \    /
                 \  /
                   3
     For undirected graph,
     we don't have any direction associated with edges
     we don't have any weight associated with edges

     DFS Path : 1   2   6   4   3   5   0

 */
public class UndirectedGraph implements Graph {

    private int numberOfVertices;
    private List<Edge> edges;
    private List<Vertex> vertices;

    public UndirectedGraph(List<Vertex> vertices) {
        this.vertices = vertices;
        this.numberOfVertices = vertices.size();
        this.edges = new ArrayList<>();
    }

    @Override
    public void addEdge(Vertex v, Vertex w) {
        Edge edge = new Edge(v, w, 0);
        edges.add(edge);
        v.addEdge(edge);
        w.addEdge(edge);

        // since it is undirected graph,
        // we add edge from v to w and
        // w to v
        edge = new Edge(w, v, 0);
        edges.add(edge);
        v.addEdge(edge);
        w.addEdge(edge);
    }

    @Override
    public Iterable<Edge> adj(Vertex v) {
        return edges.stream().filter(edge -> edge.getStartVertex().equals(v)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Edge> getEdges() {
        return edges;
    }

    @Override
    public Iterable<Vertex> geVertices() {
        return vertices;
    }

    @Override
    public int numberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public int numberOfEdges() {
        return edges.size();
    }

    @Override
    public void printGraph() {
        edges.forEach(System.out::println);
    }

}
