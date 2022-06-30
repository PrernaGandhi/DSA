package com.dsa.trees.bst.minimum_depth_of_bst;

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
        //      12
        //   4      20
        // 1    8  16   27
        MinimumDepthOfBST minimumDepthOfBST = new MinimumDepthOfBST();
        System.out.println(minimumDepthOfBST.minDepth(bst1.getRootNode()));

        bst1 = new BinarySearchTree<>();
        bst1.insert(9);
        bst1.insert(3);
        bst1.insert(20);
        bst1.insert(15);
        bst1.insert(17);
        System.out.println(minimumDepthOfBST.minDepth(bst1.getRootNode()));

    }
}
