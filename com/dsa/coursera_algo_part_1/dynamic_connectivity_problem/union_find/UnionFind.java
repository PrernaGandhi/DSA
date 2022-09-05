package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find;

public interface UnionFind {

    boolean isConnected(int p, int q);

    void union(int p, int q);

}
