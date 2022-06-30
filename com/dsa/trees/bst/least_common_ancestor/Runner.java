package com.dsa.trees.bst.least_common_ancestor;

import com.dsa.trees.bst.BinarySearchTree;

public class Runner {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20);
        binarySearchTree.insert(8);
        binarySearchTree.insert(22);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);

        LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();

        System.out.println(leastCommonAncestor.leastCommonAncestor(10, 14, binarySearchTree.getRootNode()));
        System.out.println(leastCommonAncestor.leastCommonAncestor(8, 14, binarySearchTree.getRootNode()));
        System.out.println(leastCommonAncestor.leastCommonAncestor(14, 8, binarySearchTree.getRootNode()));

        System.out.println();
        System.out.println(leastCommonAncestor.leastCommonAncestorWithoutSet(10, 14, binarySearchTree.getRootNode()));
        System.out.println(leastCommonAncestor.leastCommonAncestorWithoutSet(8, 14, binarySearchTree.getRootNode()));
        System.out.println(leastCommonAncestor.leastCommonAncestorWithoutSet(14, 8, binarySearchTree.getRootNode()));
    }
}
