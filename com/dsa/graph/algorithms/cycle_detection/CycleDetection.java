package com.dsa.graph.algorithms.cycle_detection;

import java.util.List;

public class CycleDetection {

    //  (F) --> (A) --> (C) --> (B)
    //    /\     |       |
    //     \     |       |
    //      \    |       |
    //       \   |       |
    //        \  |       V
    //         (E)      (D)
    //
    //  Cycle detected : yes

    public void detectCycles(List<Vertex> graph) {
        // there might be multiple independent clusters

        for (Vertex v : graph) {
            if (!v.isVisited())
                dfs(v);
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);

        for (Vertex v : vertex.getNeighbours()) {
            // if we encounter a vertex which is being visited,
            // it means there is a cycle
            if (v.isBeingVisited()) {
                System.out.println("There is a cycle");
                return;
            }
            if (!v.isVisited()) {
                v.setVisited(true);
                dfs(v);
            }
        }
        // set visited to true,
        // this visited is set to true only when
        // it has visited all its children
        // set is being visited to false
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}