package com.dsa.trees.bst.minimum_depth_of_bst;

import com.dsa.trees.bst.Node;

/*
        Minimum depth of a binary tree,
        - min distance from root node to leaf node


                    9
                   /  \
                 3     20
                       /
                      15
                       \
                       17

       Minimum depth = 2
 */
public class MinimumDepthOfBST {
    public int minDepth(Node root) {
        if (root == null) return 0;
        int left = minDepth(root.getLeftChild());
        int right = minDepth(root.getRightChild());
        return Math.min(left, right) + 1;
    }
}
