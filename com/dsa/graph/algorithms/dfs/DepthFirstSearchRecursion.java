package com.dsa.graph.algorithms.dfs;

import com.dsa.graph.algorithms.Vertex;

public class DepthFirstSearchRecursion {
    // underlying data-structure used is stack
    // we visit neighbouring nodes and then add to the stack
    // the item added last is visited first
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
    // DFS with 'A' as source --> A B C D E F G H
    // visit root left right

    // we visit neighbour of neighbour of neighbour of root node instead of
    // visiting all adjacent neighbours of root node
    public void dfs(Vertex vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        for (Vertex neighbour : vertex.getNeighbours()) {
            if (!neighbour.isVisited()) {
                dfs(neighbour);
            }
        }
    }
}
