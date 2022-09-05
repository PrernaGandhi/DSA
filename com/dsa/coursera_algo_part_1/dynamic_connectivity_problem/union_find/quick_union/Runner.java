package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.quick_union;

public class Runner {
    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(3,8);
        quickUnion.union(1,0);
        quickUnion.union(4,5);
        quickUnion.union(4,1);

        quickUnion.print();

        System.out.println("Is 1 connected to 3: " + quickUnion.isConnected(1, 3));
        System.out.println("Is 0 connected to 4: " + quickUnion.isConnected(4, 0));

    }
}
