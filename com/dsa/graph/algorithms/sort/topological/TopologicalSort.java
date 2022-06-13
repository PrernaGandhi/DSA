package com.dsa.graph.algorithms.sort.topological;

import com.dsa.graph.algorithms.Vertex;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    //  (5) --> (2) --> (3)
    //   |               |
    //   V               V
    //  (0) <-- (4) --> (1)
    // Topological sort : 5 4 2 3 1 0
    // DAG (Directed Acyclic Graph)
    //
    // A topological sort is a graph traversal in which each
    // node v is only visited after all of its dependencies have been visited.
    // 0 is dependent on 5 and 4, so 5 and 4 will be printed before 0
    // 1 is dependent on 3 and 4, so 3 and 4 will be printed before 1
    // 3 is dependent on 2, so 2 will be printed before 3
    // 2 is dependent on 5, so 5 will be printed before 2
    // 5 4 2 3 1 0

    /*
        Let's see how this works in action

            1.  We iterate each of the graph vertex starting from 0 to 5
            2.  If the vertex has no neighbours, we push it to the stack
            3.  If vertex has neighbours, we visit all the unvisited vertices,
            4.  The last visited neighbour is added to the stack

        (5) --> (2) --> (3)
         |               |
         V               V
        (0) <-- (4) --> (1)

                Vertex  |   Neighbours                  |   Stack
              ----------|-------------------------------|-------------
                   0    |                               |   [0]
                   1    |                               |   [1,0]
                   2    | 3 -> 1(visited already)       |   [2,3,1,0]
                   3    |   1(already visited)          |
                   4    |   1(visited), 0(visited)      |   [4,2,3,1,0]
                   5    |   2(visited), 0(visited)      |   [5,4,2,3,1,0]


        Stack : [5,4,2,3,1,0]

     */
    private Stack<Vertex> stack;

    private List<Vertex> graph;

    public TopologicalSort(List<Vertex> graph) {
        this.stack = new Stack<>();
        this.graph = graph;
    }

    public void sort() {
        for (int index = 0; index < graph.size(); ++index)
            if (!graph.get(index).isVisited())
                dfs(graph.get(index));
    }

    private void dfs(Vertex vertex) {
        vertex.setVisited(true);

        // if the vertex has neighbours,
        // we visit all the neighbours
        // the last neighbour visited gets added
        // into the stack first
        // if the vertex doesn't have any neighbours
        // it gets pushed to the stack first
        //
        for (Vertex v : vertex.getNeighbours()) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
        // visit all neighbours of the current vertex
        // and then push the current vertex to stack
        stack.push(vertex);
    }

    public void printOutput() {
        // we iterate through graph size and not stack size
        // bcoz in each iteration, stack size is decreased due
        // to popping of item in each step
        for (int index = 0; index < this.graph.size(); ++index) {
            System.out.print(this.stack.pop() + " ");
        }
    }
}
