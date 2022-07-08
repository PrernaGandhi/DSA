package com.dsa.graph.algorithms.sort.topological.v1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public List<Vertex> getTopologicalOrder(List<Vertex> graph) {
        List<Vertex> list = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        // add all the independent nodes with in-degree 0
        for (Vertex v : graph) {
            if (v.getInDegree() == 0) {
                queue.add(v);
            }
        }
        // till the queue is empty
        // decrease in degree of neighbours by 1
        // and add to the queue,
        // if in-degree is 0
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if (curr != null) {
                list.add(curr);
                for (Vertex neighbour : curr.getAdjVertices()) {
                    neighbour.setInDegree(neighbour.inDegree - 1);
                    if (neighbour.getInDegree() == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return list;
    }
}