package com.dsa.graph.algorithms.shortest_distance.using_topological_ordering;

import java.util.List;
import java.util.Stack;

public class ShortestPath {
    //      1       6       2
    // (S) --> (A) --> (B) --> (E)
    //  |     /\        |      /\
    //  |     /         |      /
    // 2|   4/         1|    1/
    //  |   /           |    /
    //  V  /     3      V   /
    //  (C) -----------> (D)
    //
    // Path         Min Distance
    // S -> A           1
    // S -> B           7
    // S -> C           2
    // S -> D           5
    // S -> E           6

    private TopologicalOrdering topologicalOrdering;

    public ShortestPath(List<Vertex> graph) {
        topologicalOrdering = new TopologicalOrdering(graph);
        // distance of the source vertex from itself is 0
        graph.get(0).setMinDistance(0);
    }

    public void compute() {
        // get the stack containing the independent vertices first
        // and the the dependent ones
        Stack<Vertex> stack = topologicalOrdering.getStack();

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            for (Edge edge : currentVertex.getEdges()) {
                Vertex targetVertex = edge.getTarget();

                // relaxation process
                // checking if the target vertex has minimum distance
                // including the current vertex or without it
                if (currentVertex.getMinDistance() + edge.getWeight() < targetVertex.getMinDistance()) {
                    targetVertex.setMinDistance(currentVertex.getMinDistance() + edge.getWeight());
                    targetVertex.setPredecessor(currentVertex);
                }
            }
        }
    }
}
