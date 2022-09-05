package com.dsa.coursera_algo_part_1.dynamic_connectivity_problem.union_find.path_compression;


public class Runner {
    public static void main(String[] args) {
        PathCompressionQuickUnion pathCompressionQuickUnion = new PathCompressionQuickUnion(10);
        pathCompressionQuickUnion.union(3,8);
        pathCompressionQuickUnion.union(1,0);
        pathCompressionQuickUnion.union(4,5);
        pathCompressionQuickUnion.union(4,1);
        pathCompressionQuickUnion.union(4,8);
        pathCompressionQuickUnion.union(7,9);
        pathCompressionQuickUnion.union(7,6);
        pathCompressionQuickUnion.union(1,7);

        pathCompressionQuickUnion.print();

        System.out.println("Is 1 connected to 3: " + pathCompressionQuickUnion.isConnected(1, 3));
        System.out.println("Is 0 connected to 4: " + pathCompressionQuickUnion.isConnected(4, 0));
        System.out.println("Is 4 connected to 2: " + pathCompressionQuickUnion.isConnected(4, 2));

    }
}
