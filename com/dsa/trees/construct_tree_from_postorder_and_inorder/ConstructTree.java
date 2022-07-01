package com.dsa.trees.construct_tree_from_postorder_and_inorder;

import com.dsa.trees.bst.Node;

/*
        Inorder     :   3, 9, 20, 15, 7
        Postorder   :   9, 15, 7, 20, 3

                         3
                       /   \
                      9     20
                           /  \
                          15   7


                     inStart         inEnd
                        |              |
                        v              v
        Inorder     ->  Left Root Right
        Postorder   ->  Left Right Root
                        ^              ^
                        |              |
                     postStart      postEnd


        Left SubTree:
            leftInStart     = inStart
            // find root int in order
            leftInEnd       = rootIndex - 1
            leftPostStart   = postStart
            // leftPostEnd - leftPostStart = leftInEnd - leftInStart
            leftPostEnd     = leftInEnd - leftInStart + leftPostStart

        Right SubTree:
            rightInStart    = rootIndex + 1
            rightInEnd      = inEnd
            rightPostStart  = leftPostEnd + 1
            rightPostEnd    = postEnd - 1


 */
public class ConstructTree {

    private Node<Integer> buildHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootNodeData = postorder[postEnd];
        int leftInStart = inStart;
        int rootNodeIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootNodeData) {
                rootNodeIndex = i;
                break;
            }
        }
        int leftInEnd = rootNodeIndex - 1;
        int leftPostStart = postStart;
        int leftPostEnd = leftInEnd - leftInStart + leftPostStart;

        int rightInStart = rootNodeIndex + 1;
        int rightInEnd = inEnd;
        int rightPostStart = leftPostEnd + 1;
        int rightPostEnd = postEnd - 1;

        Node<Integer> rootNode = new Node<>(rootNodeData, null);
        rootNode.setLeftChild(buildHelper(inorder, postorder, leftInStart, leftInEnd, leftPostStart, leftPostEnd));
        rootNode.setRightChild(buildHelper(inorder, postorder, rightInStart, rightInEnd, rightPostStart, rightPostEnd));
        return rootNode;
    }

    public Node buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildHelper(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public void print(Node<Integer> rootNode) {
        if (rootNode == null) {
            return;
        }
        int height = calculateHeight(rootNode);
        for (int i = 1; i <= height; i++) {
            levelOrder(rootNode, i);
            System.out.println();
        }
    }

    private void levelOrder(Node<Integer> rootNode, int i) {
        if (rootNode == null) {
            return;
        }
        if (i == 1) {
            System.out.print(rootNode + " ");
        } else {
            levelOrder(rootNode.getLeftChild(), i - 1);
            levelOrder(rootNode.getRightChild(), i - 1);
        }
    }

    private int calculateHeight(Node<Integer> rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int left = calculateHeight(rootNode.getLeftChild());
        int right = calculateHeight(rootNode.getRightChild());
        return Math.max(left, right) + 1;
    }
}
