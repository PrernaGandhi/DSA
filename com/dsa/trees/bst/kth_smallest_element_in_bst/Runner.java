package com.dsa.trees.bst.kth_smallest_element_in_bst;

import com.dsa.trees.bst.BinarySearchTree;

public class Runner {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);

        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
        System.out.println(kthSmallestElementInBST.findKthSmallest(binarySearchTree.getRootNode(), 1));
    }
}
