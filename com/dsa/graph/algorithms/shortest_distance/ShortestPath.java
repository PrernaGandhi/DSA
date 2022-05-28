package com.dsa.graph.algorithms.shortest_distance;

import java.util.List;
import java.util.Stack;

public class ShortestPath {
    private TopologicalOrdering topologicalOrdering;

    public ShortestPath(List<Vertex> graph) {
        topologicalOrdering = new TopologicalOrdering(graph);
        graph.get(0).setMinDistance(0);
    }

    public void compute() {
        Stack<Vertex> stack = topologicalOrdering.getStack();;

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            for (Edge edge : currentVertex.getEdges()) {
                Vertex targetVertex = edge.getTarget();

                if(currentVertex.getMinDistance() + edge.getWeight() < targetVertex.getMinDistance()) {
                    targetVertex.setMinDistance(currentVertex.getMinDistance() + edge.getWeight());
                    targetVertex.setPredecessor(currentVertex);
                }
            }
        }
    }
}
