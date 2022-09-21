package com.dsa.graphs.processing.dfs;

import com.dsa.graphs.Edge;
import com.dsa.graphs.Graph;
import com.dsa.graphs.Vertex;
import com.dsa.graphs.processing.Paths;
import java.util.Stack;

/*
              1   2
              |  /
              | /
              0 ------ 6
              |        |
              |        |
              5 ------ 4
                \    /
                 \  /
                   3
     For undirected graph,
     we don't have any direction associated with edges
     we don't have any weight associated with edges

    source vertex - 0
         DFS Path : 1   2   6   4   3   5   0
        We start from 0,
        list down it's children : (1, 2, 5, 6)
        we go to 1,
        list children: (0)
        since 0 is already visited
        add to dfs path 1,
        then we go to 2,
        list children: (0)
        since 0 is already visited
        add to dfs path 1 -> 2,
        go to 5,
        list children : (3,4)
        go to 3 :
        list children : (4, 5)
        go to 4 :
        list children : (3, 5, 6)
        since 3 is visited, go to next child
        since 5 is visited, go to next child
        go to 6 :
        list children : (0, 4)
        since 0 is visited, go to next child
        since 4 is also visited,
        add 6 to dfs path
        dfs path : 1->2->6
        now previously before 6, we were at 4,
        since all children of 4 are visited,
        we add 4 to the dfs path
        dfs path : 1->2->6->4
        now previously to 4, we were visiting 3,
        since all children of 3 are visited,
        add 3 to the dfs path
        dfs path : 1->2->6->4->3
        now previously to 3, we were visiting 5,
        since all children of 5 are visited,
        add 5 to the dfs path,
        dfs path : 1->2->6->4->3->5
        now previously to 5, we were visiting 0,
        add 0 to the dfs path
        dfs path : 1->2->6->4->3->5->0



              1   2
              ^   ^
              |  /
              | /
              0 ------> 6
              |         ^
              |         |
              v         |
              5 <------ 4
               ^       ^
                \     /
                 \   /
                   3
     For directed graph,
     we have any direction associated with edges
     we have any weight associated with edges

    source vertex - 0
        DFS Path : 1->2->5->6->0->4->3

        start from 0,
        visit children : (1,2,5,6)
        visit 1, since 1 has no children to visit,
        add to dfs path
        dfs path: 1
        visit 2, since 2 has no children to visit,
        add to dfs path
        dfs path: 1->2
        visit 5, since 5 has no children to visit,
        add to dfs path
        dfs path: 1->2->5
        visit 6, since 6 has no children to visit,
        add to dfs path
        dfs path: 1->2->5->6
        since all children of 0 are visited,
        add to dfs path
        dfs path: 1->2->5->6->0
        now lets check other vertices on graph,
        1, visited,
        2, visited,
        start with 3,
        visit children : (4,5)
        visit 4,
        children of 4 : (5, 6)
        since 5 and 6 are visited,
        we add 4 to dfs path
        dfs path: 1->2->5->6->0->4
        since all children of 3 are visited we now add 3 to dfs path
        dfs path: 1->2->5->6->0->4->3

 */
public class DFS implements Paths {

    private Stack<Vertex> dfsPath;
    Vertex sourceVertex;

    public DFS(Graph graph, Vertex sourceVertex) {
        dfsPath = new Stack<>();
        this.sourceVertex = sourceVertex;
        for (Vertex v : graph.geVertices()) {
            findPath(graph, v);
            if (!this.dfsPath.contains(v)) {
                this.dfsPath.add(v);
            }
        }
    }

    @Override
    public void print() {
        this.dfsPath.forEach(vertex -> System.out.print(vertex + " ---> "));
        System.out.println();
    }

    @Override
    public void findPath(Graph graph, Vertex currentVertex) {
        currentVertex.setVisited(true);
        for (Edge currentEdge :
            graph.adj(currentVertex)) {
            Vertex targetVertex = currentEdge.getEndVertex();
            if (!targetVertex.isVisited()) {
                findPath(graph, targetVertex);
                targetVertex.setParentVertex(currentVertex);
                this.dfsPath.push(targetVertex);
            }
        }
    }
}
