package com.dsa.graph.algorithms.bfs;

import com.dsa.graph.algorithms.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    // underlying data-structure used is queue
    // we visit neighbouring nodes and then add to the queue
    // the item first added is visited first
    //                     (A)
    //               /      |       \
    //              /       |        \
    //             /        |         \
    //           (B)       (F)       (G)
    //        /     \               /
    //     (C)      (D)            (H)
    //            /
    //          (E)
    //
    // BFS with 'A' as source --> A B F G C D H E

    public void traverse(Vertex root) {

        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);

        queue.add(root);

        while(!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            System.out.println("Actual visited vertex : " + vertex);

            List<Vertex> neighbours = vertex.getNeighbours();
            for(Vertex neighbourVertex : neighbours) {
                if(!neighbourVertex.isVisited()) {
                    neighbourVertex.setVisited(true);
                    queue.add(neighbourVertex);
                }
            }
        }
    }
}
