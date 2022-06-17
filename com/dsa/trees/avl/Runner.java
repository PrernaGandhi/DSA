package com.dsa.trees.avl;

public class Runner {
    public static void main(String[] args) {
        Tree<Integer> avlTree = new AVLTree<>();

        // left heavy situation
//        avlTree.insert(12);
//        avlTree.insert(4);
//        avlTree.insert(20);
//        avlTree.insert(1);
//        avlTree.insert(5);
//        avlTree.insert(23);
//
//        avlTree.remove(23);
//        avlTree.remove(20);

        // left left heavy situation
//        avlTree.insert(1);
//        avlTree.insert(3);
//        avlTree.insert(4);

        // left right heavy situation
//        avlTree.insert(3);
//        avlTree.insert(1);
//        avlTree.insert(2);

        // right left heavy situation
        avlTree.insert(3);
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.traverse();
    }
}
