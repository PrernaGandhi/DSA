package com.dsa.graph.algorithms.bfs;

import com.dsa.graph.algorithms.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    // underlying data-structure used is queue
    // we visit neighbouring nodes and then add to the queue
    // the item first added in the queue is visited first
    //                   (  A  )
    //               /      |       \
    //              /       |        \
    //             /        |         \
    //           (B)       (F)       (G)
    //         /     \               /
    //      (C)      (D)            (H)
    //              /
    //            (E)
    //
    // BFS with 'A' as source --> A B F G C D H E
    // It is level order traversal for tree
    // Time Complexity : O(V + E)

    // visit        'A' add B, F, G to the queue
    //  [B F G]
    // visit        'B' add C, D to the queue
    //  [F G C D]
    // visit        'F'
    //  [G C D]
    // visit        'G' add H to the queue
    //  [ C D H]
    // visit        'C'
    //  [D H]
    // visit        'D' add E to the queue
    //  [H E]
    // visit        'H'
    //  [E]
    // visit        'E'

    public void traverse(Vertex root) {

        Queue<Vertex> queue = new LinkedList<>();
        // visit the root node
        root.setVisited(true);
        //add the root node to the queue
        queue.add(root);

        while (!queue.isEmpty()) {
            // remove the first element in the queue
            Vertex vertex = queue.poll();
            System.out.println("Actual visited vertex : " + vertex);

            List<Vertex> neighbours = vertex.getNeighbours();
            // visit neighbouring vertices
            // add all neighbouring(adjacent vertices to the queue)
            for (Vertex neighbourVertex : neighbours) {
                if (!neighbourVertex.isVisited()) {
                    neighbourVertex.setVisited(true);
                    queue.add(neighbourVertex);
                }
            }
        }
    }
}
