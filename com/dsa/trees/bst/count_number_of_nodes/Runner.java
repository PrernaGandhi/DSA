package com.dsa.trees.bst.count_number_of_nodes;

import com.dsa.trees.bst.BinarySearchTree;

public class Runner {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        bst1.insert(12);
        bst1.insert(4);
        bst1.insert(20);
        bst1.insert(1);
        bst1.insert(8);
        bst1.insert(16);
        bst1.insert(27);

        CountNumberOfNodes<Integer> countNumberOfNodes = new CountNumberOfNodes<>();
        System.out.println(countNumberOfNodes.countNodes(bst1.getRootNode()));

        bst1 = new BinarySearchTree<>();
        bst1.insert(8);
        bst1.insert(5);
        bst1.insert(11);
        bst1.insert(3);
        bst1.insert(7);
        bst1.insert(9);
        bst1.insert(14);
        bst1.insert(2);
        bst1.insert(4);
        bst1.insert(6);
        bst1.insert(10);
        bst1.insert(13);
        bst1.insert(15);
        System.out.println(countNumberOfNodes.countNodes(bst1.getRootNode()));

    }
}
