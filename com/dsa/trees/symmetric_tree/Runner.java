package com.dsa.trees.symmetric_tree;

import com.dsa.trees.bst.Node;

public class Runner {
    public static void main(String[] args) {
        Node<Integer> rootNode = new Node<>(1, null);
        Node<Integer> leftChild = new Node<>(2, rootNode);
        rootNode.setLeftChild(leftChild);
        Node<Integer> rightChild = new Node<>(2, rootNode);
        rootNode.setRightChild(rightChild);
        rootNode.getLeftChild().setLeftChild(new Node<>(3, leftChild));
        rootNode.getLeftChild().setRightChild(new Node<>(4, leftChild));
        rootNode.getRightChild().setLeftChild(new Node<>(4, rightChild));
        rootNode.getRightChild().setRightChild(new Node<>(3, rightChild));

        SymmetricTree<Integer> symmetricTree = new SymmetricTree<>();
        System.out.println(symmetricTree.isSymmetric(rootNode));
        rootNode.getLeftChild().setRightChild(new Node<>(5, leftChild));
        System.out.println(symmetricTree.isSymmetric(rootNode));

    }
}
