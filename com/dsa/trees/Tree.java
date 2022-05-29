package com.dsa.trees;

public interface Tree<T> {
    public Integer getSum(Node<T> node);

    public Node<T> getSmallest(Node<T> node, int k);

    public Node<T> getRootNode();

    public void insert(T data);

    public void remove(T data);

    // in-order traversal as it yields the natural-ordering
    public void traversal();

    public T getMin();

    public T getMax();
}
