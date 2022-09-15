package com.dsa.coursera_algo_part_1.bst;

public class Node<K, V> {

    K key;
    V value;
    Node<K, V> left;
    Node<K, V> right;
    int count;

    Node(K key, V value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }
}
