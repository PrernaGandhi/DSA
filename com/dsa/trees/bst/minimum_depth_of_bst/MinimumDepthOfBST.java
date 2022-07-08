package com.dsa.trees.bst.minimum_depth_of_bst;

import com.dsa.trees.bst.Node;

/*
        Minimum depth of a binary tree,
        - min distance from root node to leaf node
        It is same as calculating height of BST,
        except for finding the minimum depth,
        we take the minimum of the two heights
        of the sub trees and add 1 to it.

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
