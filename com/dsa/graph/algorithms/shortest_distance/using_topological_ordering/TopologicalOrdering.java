package com.dsa.graph.algorithms.shortest_distance.using_topological_ordering;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
    // topological ordering means
    // dealing with the dependencies before
    // the actual vertex

    private Stack<Vertex> stack;

    public TopologicalOrdering(List<Vertex> graph) {
        stack = new Stack<>();

        // visit all nodes of graph as there
        // might be independent clusters
        for (int i = 0; i < graph.size(); i++) {
            if (!graph.get(i).isVisited()) {
                dfs(graph.get(i));
            }
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (Edge edge : vertex.getEdges()) {
            if (!edge.getTarget().isVisited()) {
                dfs(edge.getTarget());
            }
        }
        // push to stack only when all the
        // neighbours are visited
        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }
}