package com.dsa.trees.symmetric_tree;

import com.dsa.trees.bst.Node;

/*
        Symmetric BST
            Input       |       Output
    --------------------|---------------------
            4           |
          /   \         |
         2     2        |       true
        / \   / \       |
       3   4 4   3      |
    --------------------|----------------------
            1           |
           / \          |
          2   2         |       false
           \   \        |
            3   3       |

 */
public class SymmetricTree<T extends Comparable<T>> {
    private boolean helper(Node<T> leftTree, Node<T> rightTree) {
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null && rightTree != null) return false;
        if (leftTree != null && rightTree == null) return false;
        if (leftTree.getData() != rightTree.getData()) return false;
        return helper(leftTree.getLeftChild(), rightTree.getRightChild())
                && helper(leftTree.getRightChild(), rightTree.getLeftChild());
    }

    public boolean isSymmetric(Node<T> root) {
        if (root == null) {
            return true;
        }
        return helper(root.getLeftChild(), root.getRightChild());
    }
}
