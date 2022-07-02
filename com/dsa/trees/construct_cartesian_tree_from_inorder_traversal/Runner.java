package com.dsa.trees.construct_cartesian_tree_from_inorder_traversal;

import com.dsa.trees.bst.Node;

public class Runner {
    public static void main(String[] args) {
        int[] inorder = {1, 4, 5, 3, 7, 9, 0};
        CartesianTree cartesianTree = new CartesianTree();
        Node<Integer> node = cartesianTree.buildCartesianTree(inorder);
        cartesianTree.print(node);
    }
}
