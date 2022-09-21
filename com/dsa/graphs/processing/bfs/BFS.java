package com.dsa.graphs.processing.bfs;

import com.dsa.graphs.Edge;
import com.dsa.graphs.Graph;
import com.dsa.graphs.Vertex;
import com.dsa.graphs.processing.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
         BFS Path : 0(0) -> 1(1) -> 2(1) -> 5(1) -> 6(1) -> 3(2) -> 4(2)

        let's start from 0,
        add to the queue
        queue -> 0
        pop the first element from the queue ,
        add 0 to the bfs path,
        bfs path -> 0
        add children of 0 to the queue
        queue -> 1 2 5 6
        poll 1,
        add to bfs path
        bfs path -> 0 1
        add children of 1 to the queue
        queue -> 2 5 6
        poll 2,
        add to bfs path
        bfs path -> 0 1 2
        add children of 2 to the queue
        queue -> 5 6
        poll 5,
        add to bfs path
        bfs path -> 0 1 2 5
        add children of 5 to the queue
        queue -> 6 3 4
        poll 6,
        add to bfs path
        bfs path -> 0 1 2 5 6
        add children of 6 to the queue
        queue -> 3 4

        poll 3,
        add to bfs path
        bfs path -> 0 1 2 5 6 3
        add children of 3 to the queue
        queue -> 4

        poll 4,
        add to bfs path
        bfs path -> 0 1 2 5 6 3 4
        add children of 3 to the queue
        queue ->


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
     we have any weight associated with edge
         source vertex - 0
         BFS Path : 0(0) -> 1(1) -> 2(1) -> 5(1) -> 6(1)

        let's start from 0,
        add to the queue
        queue -> 0
        pop the first element from the queue ,
        add 0 to the bfs path,
        bfs path -> 0
        add children of 0 to the queue
        queue -> 1 2 5 6
        poll 1,
        add to bfs path
        bfs path -> 0 1
        add children of 1 to the queue
        queue -> 2 5 6
        poll 2,
        add to bfs path
        bfs path -> 0 1 2
        add children of 2 to the queue
        queue -> 5 6
        poll 5,
        add to bfs path
        bfs path -> 0 1 2 5
        add children of 5 to the queue
        queue -> 6
        poll 6,
        add to bfs path
        bfs path -> 0 1 2 5 6
        add children of 6 to the queue
        queue ->

        3 and 4 are not connected to the source element


 */
public class BFS implements Paths {

    List<Vertex> bfsPath;

    public BFS(Graph graph, Vertex initialVertex) {
        bfsPath = new ArrayList<>();
        bfs(initialVertex);
    }

    private void bfs(Vertex initialVertex) {
        if (initialVertex.isVisited()) {
            return;
        }
        Queue<Vertex> queue = new LinkedList<>();
        initialVertex.setVisited(true);
        double distanceFromSourceVertex = 0;
        initialVertex.setDistanceFromSourceVertex(distanceFromSourceVertex);
        queue.add(initialVertex);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            bfsPath.add(vertex);
            for (Edge edge :
                vertex.getAdjacentEdges()) {
                Vertex targetVertex = edge.getEndVertex();
                Vertex startVertex = edge.getStartVertex();
                distanceFromSourceVertex = startVertex.getDistanceFromSourceVertex() + 1;
                if (!targetVertex.isVisited()) {
                    targetVertex.setVisited(true);
                    targetVertex.setParentVertex(startVertex);
                    targetVertex.setDistanceFromSourceVertex(distanceFromSourceVertex);
                    queue.add(targetVertex);
                }
            }
        }

    }

    @Override
    public void print() {
        this.bfsPath.forEach(
            vertex -> System.out.print(vertex + "(" + vertex.getDistanceFromSourceVertex() + ")" + " --->"));
        System.out.println();
    }

    @Override
    public void findPath(Graph graph, Vertex vertex) {

    }
}
