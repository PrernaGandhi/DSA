package com.dsa.trees.bst;

import com.dsa.trees.bst.BinarySearchTree;

public class Runner {
    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(8);
        bst.insert(16);
        bst.insert(27);

        System.out.println("Max value is : " + bst.getMax());
        System.out.println("Min value is : " + bst.getMin());

        bst.traversal();

        // remove leaf node
        bst.remove(16);
        // remove with single right child, after removing 16
        bst.remove(20);
        // remove with 2 children
        //bst.remove(4);
        bst.remove(12);
        bst.traversal();

    }
}
