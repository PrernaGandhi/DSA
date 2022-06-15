package com.dsa.trees.bst.tree_traversal;


import com.dsa.trees.bst.BinarySearchTree;

public class Runner {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(8);
        bst.insert(16);
        bst.insert(27);

        Traversals<Integer> traversals = new Traversals<>();
        System.out.println("In order: ");
        traversals.inorder(bst.getRootNode());
        System.out.println();
        System.out.println("Pre order: ");
        traversals.preorder(bst.getRootNode());
        System.out.println();
        System.out.println("Post order: ");
        traversals.postorder(bst.getRootNode());
        System.out.println();
        System.out.println("Level order: ");
        traversals.levelOrder(bst.getRootNode());

    }
}
