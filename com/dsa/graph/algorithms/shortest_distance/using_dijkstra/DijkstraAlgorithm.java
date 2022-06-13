package com.dsa.graph.algorithms.shortest_distance.using_dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    // works for DAG(Directed Acyclic Graphs) and cyclic graphs
    // can handle only positive edge weights
    //  O(VlogV + E)
    //                    15
    //        (   B   ) -----> ( D )
    //       /\ |      \        /\ |
    //       /  |       \       /  |
    //     5/  4|      12\    3/   |
    //     /    |         \   /    |
    //    /  8  V       7 \/ /     |
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

    /*
        We use heap(Priority queue) as the
        underlying data structure being used
                    |                       |      Min distance from    |                           |                   |
        Step No     |       Vertex          |        source vertex      |       Heap                |   Predecessors    |
     ---------------|-----------------------|---------------------------|---------------------------|-------------------|
            1       |           A           |               0           |       [A-0]               |         null      |
                            POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH
            2       |           B           |               5           |       [B-5]               |       B<-A        |
            3       |           H           |               8           |       [B-5,H-8]           |       H<-A        |
            4       |           E           |               9           |       [B-5,H-8,E-9]       |       E<-A        |
                             POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH
            5       |           D           |               20          |     [H-8,E-9,D-20]        |   D<-B<-A         |
            6       |           C           |               17          |   [H-8,E-9,D-20,C-17]     |   C<-B<-A         |
            7       |           H           |  9(> MIN DISTANCE 8,      |   [H-8,E-9,D-20,C-17]     |   H<-A            |
                                                DON'T UPDATE HEAP)
                             POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH
            8       |           C           | 15(<17, UPDATE HEAP)      |       [E-9,D-20,C-15]     |   C<-H<-A         |
            9       |           F           |               14          |    [E-9,D-20,C-15,F-14]   |   F<-H<-A         |
                             POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH
            10      |           H           |               14          |     [D-20,C-15,F-14]      |   H<-A            |
            11      |           F           |               13          |     [D-20,C-15,F-13]      |   F<-E<-A         |
            12      |           G           |               29          |   [D-20,C-15,F-13,G-29]   |   G<-E<-A         |
                             POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH
            13      |           C           |               14          |       [D-20,C-14,G-29]    |   C<-F<-E<-A      |
            14      |           G           |               26          |       [D-20,C-14,G-26]    |   G<-F<-E<-A      |
                             POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH
            15      |           D           |               17          |       [D-17,G-26]         |   D<-C<-F<-E<-A   |
            16      |           G           |               25          |       [D-18,G-25]         |   G<-C<-F<-E<-A   |
                              POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH
            17      |           G           | 26(>25 DON'T UPDATE HEAP) |       [G-25]              |   G<-C<-F<-E<-A   |
                              POP WITH SMALLEST MINIMUM DISTANCE AND
                ADD NEIGHBOURS TO THE HEAP AFTER FINDING THE SHORTEST DISTANCE FOR EACH


    Final Solution:

        Source Vertex   |   Target Vertex   |       Path
     -------------------|-------------------|------------------------
            A           |       A           |       A
                        |       B           |       B<-A
                        |       C           |       C<-F<-E<-A
                        |       D           |       D<-C<-F<-E<-A
                        |       E           |       E<-A
                        |       F           |       F<-E<-A
                        |       G           |       G<-C<-F<-E<-A
                        |       H           |       H<-A
     */

    public void computePath(Vertex source) {
        source.setMinDistance(0);

        PriorityQueue<Vertex> heap = new PriorityQueue<>();
        heap.add(source);

        while (!heap.isEmpty()) {
            // always the smallest element gets polled first
            // we use heap as we can get the smallest item in
            // O(1) time complexity
            // and then we re-arrange the heap data structure
            Vertex currentVertex = heap.poll();
            for (Edge edge :
                    currentVertex.getNeighbours()) {
                Vertex startVertex = edge.getStartVertex();
                Vertex targetVertex = edge.getTargetVertex();

                // calculate the current distance
                Integer distance = currentVertex.getMinDistance() + edge.getWeight();

                // check if minimum distance of the target vertex
                // from the source vertex is greater than the
                // current distance, then we override the value
                // in the heap
                if (distance < targetVertex.getMinDistance()) {
                    // there is a shorter path to the target vertex
                    // so remove the target vertex from the heap
                    // with the older distance
                    // IS THIS WORKING FINE ??
                    // remove is fast with fibonacci heaps,
                    // then removing an item is quite fast
                    // but there is no implementation of fibonacci
                    // heaps available in java
                    // O(N) running time complexity of remove
                    heap.remove(targetVertex);
                    targetVertex.setMinDistance(distance);
                    targetVertex.setPredecessor(currentVertex);
                    heap.add(targetVertex);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex vertex) {

        List<Vertex> path = new ArrayList<>();
        // traverse from target vertex to source vertex
        // by traversing predecessors of each vertex
        for (Vertex currentVertex = vertex; currentVertex != null; currentVertex = currentVertex.getPredecessor()) {
            path.add(currentVertex);
        }
        Collections.reverse(path);
        return path;
    }
}