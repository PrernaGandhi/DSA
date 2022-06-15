package com.dsa.trees.bst.compare_bst;

import com.dsa.trees.bst.Node;

/*
    Compare if two BST are equal or not
 */
public class BSTCompare<T extends Comparable<T>> {

    public boolean bstCompare(Node<T> node1, Node<T> node2) {
        if (node1 == null || node2 == null) return node1 == node2;

        if (node1.getData().compareTo(node2.getData()) != 0) return false;

        return bstCompare(node1.getLeftChild(), node2.getLeftChild())
                && bstCompare(node1.getRightChild(), node2.getRightChild());

    }
}
