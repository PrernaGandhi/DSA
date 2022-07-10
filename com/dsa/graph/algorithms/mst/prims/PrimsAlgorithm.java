package com.dsa.graph.algorithms.mst.prims;

/*

          Prims algorithm for finding MST
                      6
                1 ---------- 3
             4 / |         / |
             /   |     3 /   |
            0    | 2   /     | 5
             \   |   /       |
             8 \ | /    9    |
                 2 --------- 4
 */
public class PrimsAlgorithm {

    public void compute(Vertex source) {
        source.setMinDistance(0);
        dfs(source);
    }

    private void dfs(Vertex source) {
        source.setVisited(true);
        System.out.println(source);
        for (Edge edge :
                source.getAdjList()) {

            Vertex startVertex = edge.getStartVertex();
            Vertex endVertex = edge.getEndVertex();
            if (!endVertex.isVisited()) {
                if (endVertex.getMinDistance() > edge.getWeight()) {
                    endVertex.setMinDistance(edge.getWeight());
                    endVertex.setParent(startVertex);
                    dfs(endVertex);
                }
            }
        }
    }

}
