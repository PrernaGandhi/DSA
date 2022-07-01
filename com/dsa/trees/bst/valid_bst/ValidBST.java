package com.dsa.trees.bst.valid_bst;

import com.dsa.trees.bst.Node;

/*
        Check if tree is a valid BST

 */
public class ValidBST {
    public boolean isValidBST(Node<Integer> rootNode) {
        if (rootNode == null) {
            return true;
        }
        if (rootNode.getLeftChild() != null && rootNode.getLeftChild().getData() > rootNode.getData()) {
            return false;
        }
        if (rootNode.getRightChild() != null && rootNode.getRightChild().getData() < rootNode.getData()) {
            return false;
        }
        return isValidBST(rootNode.getLeftChild()) && isValidBST(rootNode.getRightChild());
    }
}
