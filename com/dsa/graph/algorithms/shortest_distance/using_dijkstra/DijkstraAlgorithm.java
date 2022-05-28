package com.dsa.graph.algorithms.shortest_distance.using_dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

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
                    // remove is fast if fibonacci heaps, then removing an item is quite fast
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

        for (Vertex v = vertex; v != null; v = v.getPredecessor()) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }
}
