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
    //
    //  The main goals here is to find if we have a cycle
    //  For that we have two attributes in the vertex 'visited'
    //  and 'isBeingVisited'
    //  Let's see how that works
    //
    /*
           Step No      |   Vertex      |     isBeingVisited        |     visited
         ---------------|---------------|---------------------------|----------------
               1        |       F       |           true            |       false
               2        |       A       |           true            |       false
               3        |       C       |           true            |       false
               4        |       B       |           true            |       false
                            Now B doesn't have any neighbours
               5        |       B       |           false           |       true
               6        |       D       |           true            |       false
                            Now D doesn't have any neighbours
               7        |       D       |           false           |       true
               8        |       C       |           false           |       true
               9        |       E       |           true            |       false
               10       |       F       |       Now is being visited variable for F is true,
                                                that means there is a cycle detected as F
                                                is already being visited

     */

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