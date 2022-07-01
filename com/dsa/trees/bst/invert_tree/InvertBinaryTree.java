package com.dsa.trees.bst.invert_tree;

import com.dsa.trees.bst.Node;
import com.dsa.trees.bst.tree_traversal.Traversals;

/*
            Input                   |           Output
   ---------------------------------|--------------------------------
              1                     |               1
           /     \                  |           /       \
         2         3                |         3           2
      /    \     /    \             |      /    \       /    \
    4       5   6       7           |     7      6     5      4

 */
public class InvertBinaryTree {

    public Node<Integer> invert(Node<Integer> root) {
        if (root == null) {
            return root;
        }

        root = swap(root.getLeftChild(), root.getRightChild(), root);
        root.setLeftChild(invert(root.getLeftChild()));
        root.setRightChild(invert(root.getRightChild()));

        return root;
    }

    private Node<Integer> swap(Node<Integer> leftChild, Node<Integer> rightChild, Node<Integer> parentNode) {
        if (leftChild == null && rightChild == null) {
            return parentNode;
        }
        Node<Integer> temp = leftChild;
        leftChild = rightChild;
        rightChild = temp;
        if (leftChild != null) {
            parentNode = leftChild.getParentNode();
        } else if (rightChild != null) {
            parentNode = rightChild.getParentNode();
        }
        if (parentNode != null) {
            parentNode.setLeftChild(leftChild);
            parentNode.setRightChild(rightChild);
        }
        return parentNode;
    }

    public void print(Node<Integer> rootNode) {
        Traversals<Integer> traversals = new Traversals<>();
        traversals.levelOrderTraversalUsingHeight(rootNode);
    }
}