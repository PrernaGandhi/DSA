package com.dsa.trees.bst.height_of_bst;

import com.dsa.trees.bst.Node;

/*
                 8
              /     \
            5        11
          /  \      /  \
         3    7    9    14
        / \  /      \   / \
       2   4 6      10 13  15

        Height : 4

 */
public class HeightOfBST<T extends Comparable<T>> {
    public int height(Node<T> rootNode) {
        if (rootNode == null) return 0;
        int heightOfLeftTree = height(rootNode.getLeftChild());
        int heightOfRightTree = height(rootNode.getRightChild());
        return Math.max(heightOfLeftTree, heightOfRightTree) + 1;
    }
}
