package com.dsa.graph.algorithms.cycle_detection;

import java.util.List;

public class CycleDetection {

    public void detectCycles(List<Vertex> graph) {
        // there are multiple independent clusters

        for (Vertex v : graph) {
            if (!v.isVisited())
                dfs(v);
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);

        for (Vertex v : vertex.getNeighbours()) {
            if (v.isBeingVisited()) {
                System.out.println("There is a cycle");
                return;
            }
            if (!v.isVisited()) {
                v.setVisited(true);
                dfs(v);
            }
        }
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}