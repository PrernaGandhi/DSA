package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.quick_find;

public class Runner {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);

        quickFind.union(3,8);
        quickFind.union(1,0);
        quickFind.union(4,5);
        quickFind.union(5,1);

        System.out.println("Is 1 connected to 3: " + quickFind.isConnected(1, 3));
        System.out.println("Is 0 connected to 4: " + quickFind.isConnected(0, 4));
    }
}
