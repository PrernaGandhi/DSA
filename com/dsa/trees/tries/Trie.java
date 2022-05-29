package com.dsa.trees.tries;

public class Trie {
    private Node rootNode;

    public Trie() {
        rootNode = new Node("");
    }

    public void insert(String key) {
        Node currentNode = rootNode;

        // consider all letters in the key
        for (Character character : key.toCharArray()) {
            int asciiValue = character - 'a';

            if (currentNode.getChild(asciiValue) == null) {
                Node node = new Node(String.valueOf(character));
                currentNode.setChild(asciiValue, node);
                currentNode = node;
            } else {
                currentNode = currentNode.getChild(asciiValue);
            }
        }

        currentNode.setLeafNode(true);
    }

    public boolean search(String key) {
        Node currentNode = rootNode;
        for (Character character : key.toCharArray()) {
            int asciiValue = character - 'a';

            if(currentNode.getChild(asciiValue) != null) {
                currentNode = currentNode.getChild(asciiValue);
            } else {
                System.out.println("Key Not Found : " + key);
                return false;
            }
        }
        if (!currentNode.isLeafNode()) {
            System.out.println("Key Not Found : " + key);
            return false;
        }
        return true;
    }
}
