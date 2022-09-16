package com.dsa.coursera_algo_part_1.bst.red_black_trees;

public class Runner {

    public static void main(String[] args) {

        RedBlackTrees<String, String> redBlackTrees = new RedBlackTrees<>();
        redBlackTrees.insert("A","A");
        redBlackTrees.insert("B","B");
        redBlackTrees.insert("C","C");
        redBlackTrees.print();
        redBlackTrees.insert("D","D");
        redBlackTrees.insert("E","E");
        redBlackTrees.insert("F","F");
        redBlackTrees.print();
    }

}
