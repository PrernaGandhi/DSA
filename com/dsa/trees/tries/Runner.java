package com.dsa.trees.tries;

public class Runner {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("air");
        trie.insert("apple");
        trie.insert("approve");
        trie.insert("bee");

        System.out.println(trie.search("airstrike"));
        System.out.println(trie.search("air"));
        System.out.println(trie.search("app"));
    }
}
