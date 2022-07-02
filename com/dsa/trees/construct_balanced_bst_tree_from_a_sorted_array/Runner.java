package com.dsa.trees.construct_balanced_bst_tree_from_a_sorted_array;

import com.dsa.trees.bst.Node;
import com.dsa.trees.bst.tree_traversal.Traversals;

public class Runner {
    public static void main(String[] args) {
        int[] inorder = {1, 2, 3, 4, 5, 6, 7};
        Traversals traversals = new Traversals();
        ConstructBalancedBST constructBalancedBST = new ConstructBalancedBST();
        Node<Integer> rootNode = constructBalancedBST.constructBalancedBST(inorder);
        traversals.levelOrderTraversalUsingHeight(rootNode);
    }
}
