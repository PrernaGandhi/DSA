package com.dsa.coursera_algo_part_1.symbol_tables;

import com.dsa.coursera_algo_part_1.bst.BST;

/*

    Symbol tables are key value pairs and can be implemented using the following methods:

    1. We can use linked list, to store elements in symbol table
    cost : Search O(N)
    cost : Insert O(N)

    2. Binary search in ordered array :
    we use two parallel arrays, one for key and one for values,
    we find the index of key using binary search and return corresponding to that
    index from the values array
    search O(log N)
    insert O(N)

    3. Binary search tree
    search O(log N)
    insert O(log N)

 */
public class SymbolTable<K extends Comparable<K>, V extends Comparable<V>> {

    BST<K, V> bst;

    public SymbolTable() {
        this.bst = new BST<>();
    }

    public void put(K key, V value) {
        bst.put(key, value);
    }

    public V get(K key) {
        return bst.get(key);
    }

    public void print() {
        bst.print();
    }
}
