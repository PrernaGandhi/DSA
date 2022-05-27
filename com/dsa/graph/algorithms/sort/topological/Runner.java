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

        for (int i = 0; i < graph.size(); ++i)
            if (!graph.get(i).isVisited())
                topologicalSort.dfs(graph.get(i));

        topologicalSort.printOutput();
    }
}
