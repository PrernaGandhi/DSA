package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.weighted_quick_union;


public class Runner {
    public static void main(String[] args) {
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
        weightedQuickUnion.union(3,8);
        weightedQuickUnion.union(1,0);
        weightedQuickUnion.union(4,5);
        weightedQuickUnion.union(4,1);
        weightedQuickUnion.union(4,8);

        weightedQuickUnion.print();

        System.out.println("Is 1 connected to 3: " + weightedQuickUnion.isConnected(1, 3));
        System.out.println("Is 0 connected to 4: " + weightedQuickUnion.isConnected(4, 0));
        System.out.println("Is 4 connected to 2: " + weightedQuickUnion.isConnected(4, 2));

    }
}
