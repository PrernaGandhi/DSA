package com.dsa.trees.bst.tree_traversal;


import com.dsa.trees.bst.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals<T> {
    //           (12)
    //          /    \
    //        (4)    (20)
    //        / \    /  \
    //      (1) (8)(16) (27)
    //
    //  inorder :   1 4 8 12 16 20 27
    //  preorder:   12 4 1 8 20 16 27
    //  postorder:  1 8 4 16 27 20 12
    //  levelorder: 12 4 20 1 8 16 27

    public void inorder(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() != null) {
            inorder(node.getLeftChild());
        }

        System.out.print(node + " ");

        if (node.getRightChild() != null) {
            inorder(node.getRightChild());
        }
    }

    public void preorder(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.print(node + " ");

        if (node.getLeftChild() != null) {
            preorder(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            preorder(node.getRightChild());
        }
    }

    public void postorder(Node<T> node) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() != null) {
            postorder(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            postorder(node.getRightChild());
        }

        System.out.print(node + " ");
    }

    // matches with implementation of bfs
    public void levelOrder(Node<T> node) {
        if (node == null)
            return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);
        node.setVisited(true);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.print(current + " ");
            if (current.getLeftChild() != null)
                queue.add(current.getLeftChild());
            if (current.getRightChild() != null)
                queue.add(current.getRightChild());
        }
    }

}
