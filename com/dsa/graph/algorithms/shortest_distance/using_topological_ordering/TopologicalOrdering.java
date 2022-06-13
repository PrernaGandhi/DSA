package com.dsa.graph.algorithms.shortest_distance.using_topological_ordering;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
    // topological ordering means
    // dealing with the dependencies before
    // the actual vertex
    //      1       6       2
    // (S) --> (A) --> (B) --> (E)
    //  |     /\        |      /\
    //  |     /         |      /
    // 2|   4/         1|    1/
    //  |   /           |    /
    //  V  /     3      V   /
    //  (C) -----------> (D)
    //

    /*
        Current Vertex  |       Neighbours      |   Stack
      ------------------|-----------------------|------------------
            S           |   A->B->E,D,C->D,A    |   [S,C,A,B,D,E]
            A           |     B(visited)        |   [S,C,A,B,D,E]
            B           |     E,D(visited)      |   [S,C,A,B,D,E]
            C           |     A,D(visited)      |   [S,C,A,B,D,E]
            D           |     E(visited)        |   [S,C,A,B,D,E]
            E           |     no neighbours     |   [S,C,A,B,D,E]

        Stack : [S,C,A,B,D,E]
        
     */
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