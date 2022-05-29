package com.dsa.trees.bst.compare_bst;

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
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.insert(12);
        bst2.insert(4);
        bst2.insert(20);
        bst2.insert(1);
        bst2.insert(8);
        bst2.insert(16);
        bst2.insert(27);
        BSTCompare<Integer> bstCompare = new BSTCompare<>();
        System.out.println(bstCompare.bstCompare(bst1.getRootNode(), bst2.getRootNode()));
        bst2.insert(11);
        System.out.println(bstCompare.bstCompare(bst1.getRootNode(), bst2.getRootNode()));

    }
}
