package com.dsa.graphs.directed_graphs;

import com.dsa.graphs.Edge;
import com.dsa.graphs.Graph;
import com.dsa.graphs.Vertex;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
              1   2
              ^   ^
              |  /
              | /
              0 ------> 6
              |         ^
              |         |
              v         |
              5 <------ 4
               ^       ^
                \     /
                 \   /
                   3
     For directed graph,
     we have any direction associated with edges
     we have any weight associated with edges

     DFS Path : 1->2->5->6->0->4->3
 */
public class DirectedGraph implements Graph {

    private int numberOfVertices;
    private List<Edge> edges;
    private List<Vertex> vertices;

    public DirectedGraph(List<Vertex> vertices) {
        this.vertices = vertices;
        this.numberOfVertices = vertices.size();
        this.edges = new ArrayList<>();
    }

    @Override
    public void addEdge(Vertex v, Vertex w) {
        Edge edge = new Edge(v, w, 0);
        edges.add(edge);
        v.addEdge(edge);

        // since it is directed graph,
        // we don't add edge from
        // w to v as the edge is directed
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
    public Iterable<Vertex> getVertices() {
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
