package com.dsa.graph.algorithms.shortest_distance.using_topological_ordering;

import java.util.List;
import java.util.Stack;

public class ShortestPath {
    // Doesn't work with non negative weights
    // does not work with cycles
    //  O(V + E)
    //      1       6       2
    // (S) --> (A) --> (B) --> (E)
    //  |     /\        |      /\
    //  |     /         |      /
    // 2|   4/         1|    1/
    //  |   /           |    /
    //  V  /     3      V   /
    //  (C) -----------> (D)

    /*
        We first get the stack based on topological sorting
        Stack : [S,C,A,B,D,E]

                        |                   | (curr.minDist |                   |                   |
                        |                   |       +       |                   |                   |
       Source | Current |                   |   edgeWeight) |                   |                   |
       Vertex | Vertex  |   Target Vertex   |   Distance    |   Min distance    |       Path        |   Stack
      --------|---------|-------------------|---------------|-------------------|-------------------|--------------
              |     S   |          A        |       1       |       1           |   S->A            |   [C,A,B,D,E]
              |         |          C        |       2       |       2           |   S->C            |   [C,A,B,D,E]
              -----------------------------------------------------------------------------------------------------
              |     C   |          A        |       6       |       1           |   S->A            |   [A,B,D,E]
              |         |          D        |       5       |       5           |   S->C->D         |   [A,B,D,E]
              -----------------------------------------------------------------------------------------------------
              |     A   |          B        |       7       |       7           |   S->A->B         |   [B,D,E]
        S     -----------------------------------------------------------------------------------------------------
              |     B   |          E        |       9       |       9           |   S->A->B->E      |   [D,E]
              |         |          D        |       8       |       5           |   S->C->D         |   [D,E]
              -----------------------------------------------------------------------------------------------------
              |     D   |          E        |       6       |       6           |   S->C->D->E      |   [E]
              -----------------------------------------------------------------------------------------------------
              |     E   |                   |               |                   |                   |   []

     */

    // Source->Destination         Min Distance         Path followed
    //      S -> A                      1                   S->A
    //      S -> B                      7                   S->A->B
    //      S -> C                      2                   S->C
    //      S -> D                      5                   S->C->D
    //      S -> E                      6                   S->C->D->E

    private TopologicalOrdering topologicalOrdering;
    private List<Vertex> graph;

    public ShortestPath(List<Vertex> graph) {
        topologicalOrdering = new TopologicalOrdering(graph);
        // distance of the source vertex from itself is 0
        graph.get(0).setMinDistance(0);
        this.graph = graph;
    }

    public void compute() {
        // get the stack containing the independent vertices first
        // and the the dependent ones
        Stack<Vertex> stack = topologicalOrdering.getStack();

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            for (Edge edge : currentVertex.getEdges()) {
                Vertex targetVertex = edge.getTarget();

                // relaxation process
                // checking if the target vertex has minimum distance
                // including the current vertex or without it
                if (currentVertex.getMinDistance() + edge.getWeight() < targetVertex.getMinDistance()) {
                    targetVertex.setMinDistance(currentVertex.getMinDistance() + edge.getWeight());
                    targetVertex.setPredecessor(currentVertex);
                }
            }
        }
    }

    public void printSolution() {
        // distance of each vertex from source vertex
        for (Vertex vertex : this.graph) {
            System.out.println(vertex.getName() + " - " + vertex.getPredecessor() + "\t: " + vertex.getMinDistance());
        }

    }
}
