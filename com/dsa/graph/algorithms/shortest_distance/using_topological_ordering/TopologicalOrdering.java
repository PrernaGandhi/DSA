package com.dsa.graph.algorithms.shortest_distance.using_topological_ordering;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {

    private Stack<Vertex> stack;

    public TopologicalOrdering(List<Vertex> graph) {
        stack = new Stack<>();

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
        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }
}