package com.dsa.graph.algorithms.shortest_distance.using_dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    //                15
    //        (   B   ) -----> ( D )
    //       /\ |      \        /\ |
    //       /  |       \       /  |
    //     5/  4|      12\    3/   |
    //     /    |         \   /    |
    //    /  8  V  7      \/ /     |
    // (A) ---> (  H  ) --> ( C )  |
    //  |         /\ |       /\ |  |
    //  |         / 6|       /  |  |
    //  |        /   |     1/   |  |
    //  |       /    |     /    |  |
    // 9|     5/     V    /     |  |
    //  |     /   (  F  )       |  |
    //  |    /    /\     \      | 9|
    //  |   /     /       \     |  |
    //  |  /   4/        13\  11|  |
    //  | /   /             \   |  |
    //  V/  /        20      \/  V  V
    // (  E  ) ------------> (  G  )


    public void computePath(Vertex source) {
        source.setMinDistance(0);

        PriorityQueue<Vertex> heap = new PriorityQueue<>();
        heap.add(source);

        while (!heap.isEmpty()) {
            Vertex currentVertex = heap.poll();
            for (Edge edge :
                    currentVertex.getNeighbours()) {
                Vertex startVertex = edge.getStartVertex();
                Vertex targetVertex = edge.getTargetVertex();

                Integer distance = currentVertex.getMinDistance() + edge.getWeight();

                if (distance < targetVertex.getMinDistance()) {
                    // there is a shorter path to the target vertex
                    // IS THIS WORKING FINE ??
                    // remove is fast with fibonacci heaps,
                    // then removing an item is quite fast
                    // but there is no implementation of fibonacci
                    // heaps available in java
                    // O(N) running time complexity of remove
                    heap.remove(targetVertex);
                    targetVertex.setMinDistance(distance);
                    targetVertex.setPredecessors(currentVertex);
                    heap.add(targetVertex);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex vertex) {

        List<Vertex> path = new ArrayList<>();

        // traverse from target vertex to source vertex
        // by traversing predecessors of each vertex
        for (Vertex v = vertex; v != null; v = v.getPredecessor()) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }
}
