package com.dsa.graph.algorithms.sort.topological;

import com.dsa.graph.algorithms.Vertex;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    //  (5) --> (2) --> (3)
    //   |               |
    //   V               V
    //  (0) <-- (4) --> (1)
    // Topological sort : 5 4 2 3 1 0
    // DAG (Directed Acyclic Graph)
    //
    // A topological sort is a graph traversal in which each
    // node v is only visited after all of its dependencies have been visited.
    // 0 is dependent on 5 and 4, so 5 and 4 will be printed before 0
    // 1 is dependent on 3 and 4, so 3 and 4 will be printed before 1
    // 3 is dependent on 2, so 2 will be printed before 3
    // 2 is dependent on 5, so 5 will be printed before 2
    // 5 4 2 3 1 0

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
        // visit all neighbours of the current vertex
        // and then push the current vertex to stack
        stack.push(vertex);
    }

    public void printOutput() {
        // we iterate through graph size and not stack size
        // bcoz in each iteration, stack size is decreased due
        // to popping of item in each step
        for(int i = 0; i < this.graph.size(); ++i) {
            System.out.print(this.stack.pop() + " ");
        }
    }
}
