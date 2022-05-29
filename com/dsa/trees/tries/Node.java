package com.dsa.trees.tries;

public class Node {
    private String character;
    private Node[] children;
    private boolean isLeafNode;
    private boolean isVisited;

    public Node(String character) {
        this.character = character;
        // this is why tries are memory inefficient
        children = new Node[Constants.ALPHABET_SIZE];
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Node[] getChildren() {
        return children;
    }

    public Node getChild(int index) {
        return children[index];
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isLeafNode() {
        return isLeafNode;
    }

    public void setLeafNode(boolean leafNode) {
        isLeafNode = leafNode;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return character;
    }

    public void setChild(int index, Node node) {
        children[index] = node;
    }
}
