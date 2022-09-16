package com.dsa.coursera_algo_part_1.bst.red_black_trees;

public class Node<K extends Comparable<K>, V extends Comparable<V>> {

    K key;
    V value;
    Node<K, V> left;
    Node<K, V> right;
    boolean color; // color of link with parent node

    public Node(K key, V value, boolean color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }
}
