package com.dsa.trees.bst.count_number_of_nodes;

import com.dsa.trees.bst.Node;

/*
        Count number of nodes

                 8
              /     \
            5        11
          /  \      /  \
         3    7    9    14
        / \  /      \   / \
       2   4 6      10 13  15


       Number of nodes : 13

       Approach :
        no of nodes = nodes of left sub tree + nodes of right sub tree + 1(root node)

        base case if root == null , then count of node  = 0
 */
public class CountNumberOfNodes<T extends Comparable<T>> {
    public int countNodes(Node<T> rootNode) {
        if (rootNode == null) {
            return 0;
        }
        return countNodes(rootNode.getLeftChild()) + countNodes(rootNode.getRightChild()) + 1;
    }
}
