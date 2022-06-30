package com.dsa.trees.bst.least_common_ancestor;

import com.dsa.trees.bst.Node;

import java.util.HashSet;
import java.util.Set;

/*
        Find least common ancestor (LCA)
                        20
                      /    \
                    8        22
                  /   \
                 4    12
                    /    \
                   10     14

            LCA(10, 14) :   12
                Ancestors of 10 : 10, 12, 8, 20
                Ancestors of 14 : 14, 12, 8, 20

            LCA(8, 14)  :   8
                Ancestors of 8  : 8, 20
                Ancestors of 14 : 14, 12, 8, 20

        least common ancestor would be in between the two numbers,
        or the smaller node would be the ancestor,
        from the top the first number between the two numbers
        would be the least common ancestor
 */
public class LeastCommonAncestor {
    public Node<Integer> leastCommonAncestor(int val1, int val2, Node<Integer> rootNode) {
        // search nodes in bst
        Node<Integer> node1 = searchNodeInBST(val1, rootNode);
        Node<Integer> node2 = searchNodeInBST(val2, rootNode);
        Set<Node<Integer>> nodes = new HashSet<>();
        while (node1 != null) {
            nodes.add(node1);
            node1 = node1.getParentNode();
        }
        while (node2 != null) {
            if (nodes.contains(node2)) {
                return node2;
            }
            node2 = node2.getParentNode();
        }
        return null;
    }

    public Node<Integer> leastCommonAncestorWithoutSet(int val1, int val2, Node<Integer> rootNode) {
        // search nodes in bst
        Node<Integer> node1 = searchNodeInBST(val1, rootNode);
        Node<Integer> node2 = searchNodeInBST(val2, rootNode);
        while (rootNode != null) {
            if (node1.getData() < rootNode.getData() && node2.getData() < rootNode.getData()) {
                rootNode = rootNode.getLeftChild();
            } else if (node1.getData() > rootNode.getData() && node2.getData() > rootNode.getData()) {
                rootNode = rootNode.getRightChild();
            } else {
                return rootNode;
            }
        }
        return null;
    }


    private Node<Integer> searchNodeInBST(int val1, Node<Integer> rootNode) {
        if (rootNode == null) {
            return null;
        }
        if (val1 == rootNode.getData()) {
            return rootNode;
        } else if (val1 < rootNode.getData()) {
            return searchNodeInBST(val1, rootNode.getLeftChild());
        } else {
            return searchNodeInBST(val1, rootNode.getRightChild());
        }
    }
}
