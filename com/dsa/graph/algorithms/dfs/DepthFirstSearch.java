package com.dsa.graph.algorithms.dfs;

import com.dsa.graph.algorithms.Vertex;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
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
    // DFS with 'A' as source --> A G H F B D E C
    public void traverse(Vertex vertex) {
        Stack<Vertex> stack = new Stack<>();
        vertex.setVisited(true);
        stack.add(vertex);

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            System.out.println(currentVertex);

            List<Vertex> neighbours = currentVertex.getNeighbours();
            for (Vertex neighbour : neighbours) {
                if(!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    stack.add(neighbour);
                }
            }
        }

    }
}
