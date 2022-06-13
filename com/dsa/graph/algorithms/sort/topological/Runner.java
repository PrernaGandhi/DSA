package com.dsa.graph.algorithms.sort.topological;

import com.dsa.graph.algorithms.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Vertex> graph = new ArrayList<>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbour(graph.get(3));

        graph.get(3).addNeighbour(graph.get(1));

        graph.get(4).addNeighbour(graph.get(0));
        graph.get(4).addNeighbour(graph.get(1));

        graph.get(5).addNeighbour(graph.get(0));
        graph.get(5).addNeighbour(graph.get(2));

        TopologicalSort topologicalSort = new TopologicalSort(graph);

        // we iterate through each vertex of the graph
        // this is done for cases like 0 vertex has no neighbours
        // now if 0 is the starting vertex, we don't have any way to
        // visit the other vertices
        topologicalSort.sort();
        topologicalSort.printOutput();
    }
}
