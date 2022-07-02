package com.dsa.trees.construct_cartesian_tree_from_inorder_traversal;

import com.dsa.trees.bst.Node;

/*
        Cartesian Tree  :   heap ordered binary tree,
                            where the root is greater
                            than all the elements in
                            the subtree

        Assumption : no duplicates

        Input : [1, 2, 3]

                    3
                  /
                 2
               /
              1


    Example : [1, 4, 5, 3, 7, 9, 0]

    this is inorder traversal -> Left Data Right

    root data would be the max value : 9

                   9
                 /  \
                7    0
               /
              5
            /   \
           4     3
         /
        1
 */
public class CartesianTree {
    private Node<Integer> buildCartesianTreeHelper(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        // find the root node
        // means find the max element
        int rootData = Integer.MIN_VALUE;
        int rootDataIndex = -1;

        for (int i = start; i <= end; i++) {
            if (rootData < inorder[i]) {
                rootData = inorder[i];
                rootDataIndex = i;
            }
        }
        Node<Integer> rootNode = new Node<>(rootData, null);
        rootNode.setLeftChild(buildCartesianTreeHelper(inorder, start, rootDataIndex - 1));
        rootNode.setRightChild(buildCartesianTreeHelper(inorder, rootDataIndex + 1, end));
        return rootNode;
    }

    public Node<Integer> buildCartesianTree(int[] inorder) {
        int n = inorder.length;
        return buildCartesianTreeHelper(inorder, 0, n - 1);
    }

    public void print(Node<Integer> node) {
        if (node == null) {
            return;
        }
        int height = calculateHeight(node);
        for (int i = 1; i <= height; i++) {
            levelOrder(node, i);
            System.out.println();
        }
    }

    private void levelOrder(Node<Integer> node, int i) {
        if (node == null) {
            return;
        }
        if (i == 1) {
            System.out.print(node + " ");
        } else {
            levelOrder(node.getLeftChild(), i - 1);
            levelOrder(node.getRightChild(), i - 1);
        }
    }

    private int calculateHeight(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        int left = calculateHeight(node.getLeftChild());
        int right = calculateHeight(node.getRightChild());
        return Math.max(left, right) + 1;
    }
}
