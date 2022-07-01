package com.dsa.trees.construct_tree_from_preorder_and_inorder;

import com.dsa.trees.bst.Node;

public class Runner {
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        ConstructTree constructTree = new ConstructTree();
        Node<Integer> rootNode = constructTree.buildTree(inOrder, preOrder);
        constructTree.print(rootNode);
    }
}
