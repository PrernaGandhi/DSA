package com.dsa.trees.bst.invert_tree;

import com.dsa.trees.bst.BinarySearchTree;

public class Runner {
    public static void main(String[] args) {

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(8);
        bst.insert(5);
        bst.insert(11);
        bst.insert(3);
        bst.insert(7);
        bst.insert(9);
        bst.insert(14);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(10);
        bst.insert(13);
        bst.insert(15);
        invertBinaryTree.print(bst.getRootNode());
        invertBinaryTree.invert(bst.getRootNode());
        invertBinaryTree.print(bst.getRootNode());
    }
}
