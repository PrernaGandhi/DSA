package com.dsa.graph.algorithms.sort.topological;

import com.dsa.graph.algorithms.Vertex;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    private Stack<Vertex> stack;

    private List<Vertex> graph;

    public TopologicalSort(List<Vertex> graph) {
        this.stack = new Stack<>();
        this.graph = graph;
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (Vertex v : vertex.getNeighbours()) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
        stack.push(vertex);
    }

    public void printOutput() {
        for(int i = 0; i < this.graph.size(); ++i) {
            System.out.print(this.stack.pop() + " ");
        }
    }
}
