package com.dsa.trees.construct_tree_from_postorder_and_inorder;

import com.dsa.trees.bst.Node;

public class Runner {
    public static void main(String[] args) {
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inOrder = {9, 3, 15, 20, 7};

        ConstructTree constructTree = new ConstructTree();
        Node<Integer> rootNode = constructTree.buildTree(inOrder, postOrder);
        constructTree.print(rootNode);
    }
}
