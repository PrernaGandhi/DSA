package com.dsa.trees.bst.diameter_of_tree_better_approach;

import com.dsa.trees.bst.BinarySearchTree;
import com.dsa.trees.bst.tree_traversal.Traversals;

public class Runner {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(20);
        bst.insert(22);
        bst.insert(15);
        bst.insert(16);
        bst.insert(17);
        bst.insert(18);
        bst.insert(14);
        bst.insert(13);
        bst.insert(12);
        Traversals<Integer> traversals = new Traversals<>();
        traversals.levelOrderTraversalUsingHeight(bst.getRootNode());
        DiameterOfTree diameterOfTree = new DiameterOfTree();
        System.out.println(diameterOfTree.diameter(bst.getRootNode()));

    }
}
