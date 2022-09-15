package com.dsa.coursera_algo_part_1.bst;

/*
    A BST is a binary tree in symmetric order

    A binary tree is either:
        1. Empty
        2. Two disjoint binary tress (left and right)


 */
public class BST<K extends Comparable<K>, V extends Comparable<V>> {

    private Node<K, V> root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /*
     1+ logN(depth of tree)
     */
    private Node<K, V> put(Node<K, V> current, K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        if (current == null) {
            return node;
        }

        int compare = key.compareTo(current.key);
        if (compare < 0) {
            current.left = put(current.left, key, value);
        } else if (compare > 0) {
            current.right = put(current.right, key, value);
        } else {
            current.value = value;
        }
        return current;
    }

    /*
     cost : 1 + logN
     */
    public V get(K key) {
        Node<K, V> current = root;

        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;
    }

    public V getRecursive(K key) {
        return get(root, key);
    }

    private V get(Node<K, V> current, K key) {
        if (current == null) {
            return null;
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            return get(current.left, key);
        } else if (compare > 0) {
            return get(current.right, key);
        } else {
            return current.value;
        }

    }

    public int calculateHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node<K, V> current) {
        if (current == null) {
            return 0;
        }
        int lh = calculateHeight(current.left);
        int rh =  calculateHeight(current.right);
        return 1 + Math.max(lh, rh);
    }

    public void print() {
        Node<K, V> current = root;
        for (int i = 1; i <= calculateHeight(current); i++) {
            levelOrder(current, i);
            System.out.println();
        }
    }

    public void levelOrder(Node<K, V> current, int level) {
        if (current == null) {
            return;
        }
        if (level == 1) {
            System.out.print(current.value + " ");
        } else {
            levelOrder(current.left, level - 1);
            levelOrder(current.right, level - 1);
        }
    }

}
