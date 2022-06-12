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

    public void traverse(Vertex rootNode) {
        Stack<Vertex> stack = new Stack<>();
        // visit root node
        rootNode.setVisited(true);
        // add root node to stack
        stack.add(rootNode);

        while (!stack.isEmpty()) {
            // pop the topmost element of stack
            Vertex currentVertex = stack.pop();
            System.out.println(currentVertex);

            // visit the neighbours and add the non visited
            // to the stack and pop one by one
            List<Vertex> neighbours = currentVertex.getNeighbours();
            for (Vertex neighbour : neighbours) {
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    stack.add(neighbour);
                }
            }
        }
    }
}
