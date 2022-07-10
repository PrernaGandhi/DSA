package com.dsa.graph.algorithms.mst.kruskal;

import java.util.*;

/*
        Kruskal Algorithm is used to find MST (minimum spanning tree)

        there are 3 functionalities
            1.  makeset - create set with 1 element
            2.  find    - finding the representative element
                            for the vertex [find parent elements,
                            if parent elements are same,
                            they are in the same set,
                            hence the same connected components]
            3.  union   - union of two elements

            If the elements are in the same set (which means they are
            in the same connected components) so it forms a cycle


        Steps :
            1.  For each vertex, makeset
            2.  Sort the edges in increasing order of weights
            3.  Pick each edge containing vertex u and vertex v,
                we need to check if they are not in the same set
                i.e, not in the same connected component,
                then we add to the MST, and we can club these two sets


       Example :
                   8           7
            1 --------- 2 ---------- 3
       4  / |      2  /   \          | \
         /  |       /       \        |  \ 9
       0  11|     8           \ 4    |14 \
         \  |   /   \ 6         \    |    4
        8 \ | / 7     \           \  |  / 10
            7 --------- 6 --------- 5
                  1           2

    MST -


           1         2 -------- 3
         /         /   \          \
        0         8     \          4
         \               \
           7 ---- 6 ----- 5

 */
public class KruskalAlgorithm {

    private Map<Vertex, List<Vertex>> connectedComponents;

    KruskalAlgorithm() {
        connectedComponents = new HashMap<>();
    }

    public List<Edge> algo(List<Vertex> graph) {
        List<Edge> result = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (Vertex v :
                graph) {
            makeSet(v);
            edges.addAll(v.getAdjList());
        }

        Collections.sort(edges);
        for (Edge edge :
                edges) {
            Vertex startVertex = edge.getStartVertex();
            Vertex endVertex = edge.getEndVertex();
            if (!isConnected(startVertex, endVertex)) {
                union(startVertex, endVertex);
                result.add(edge);
            }
        }
        return result;
    }

    public void makeSet(Vertex vertex) {
        connectedComponents.put(vertex, Arrays.asList(vertex));
        vertex.setParent(vertex);
    }

    public Vertex find(Vertex vertex) {
        return vertex.getParent();
    }

    public void union(Vertex v1, Vertex v2) {
        // that means they are not in the same
        // connected components
        Vertex v = v2.getParent();
        List<Vertex> list = connectedComponents.get(v);
        Vertex parent = v1.getParent();
        list.forEach(vertex -> vertex.setParent(parent));
        List<Vertex> vertexList = connectedComponents.get(parent);
        List<Vertex> resultList = new ArrayList<>();
        resultList.addAll(list);
        resultList.addAll(vertexList);
        connectedComponents.remove(v);
        connectedComponents.put(parent, resultList);
    }

    public boolean isConnected(Vertex v1, Vertex v2) {
        if (v1.getParent() == v2.getParent()) {
            return true;
        }
        return false;
    }
}
