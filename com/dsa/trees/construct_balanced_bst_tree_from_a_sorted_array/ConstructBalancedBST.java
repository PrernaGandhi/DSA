package com.dsa.trees.construct_balanced_bst_tree_from_a_sorted_array;

import com.dsa.trees.bst.Node;

/*
        Example : [1,2,3,4,5,6,7]

        We need to build balanced BST from a sorted array

        Find the mid element,
        all elements to left of mid,
        are elements of left subtree.
        all elements to right of mid,
        are elements of right subtree.

                      4
                   /    \
                  2      6
                /  \    /  \
               1    3  5    7
 */
public class ConstructBalancedBST {
    private Node<Integer> constructTreeHelper(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        // find mid element
        int rootIndex = (start + end) / 2;
        int rootData = inorder[rootIndex];
        int leftStart = start;
        int leftEnd = rootIndex - 1;

        int rightStart = rootIndex + 1;
        int rightEnd = end;

        Node<Integer> rootNode = new Node<>(rootData, null);
        rootNode.setLeftChild(constructTreeHelper(inorder, leftStart, leftEnd));
        rootNode.setRightChild(constructTreeHelper(inorder, rightStart, rightEnd));

        return rootNode;
    }

    public Node<Integer> constructBalancedBST(int[] inorder) {
        int n = inorder.length;
        return constructTreeHelper(inorder, 0, n - 1);
    }
}
