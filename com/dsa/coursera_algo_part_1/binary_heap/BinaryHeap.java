package com.dsa.coursera_algo_part_1.binary_heap;

/*
    Binary Heaps are such that parent node is always greater than it's child in case of
    Max Heap

    Note we are using array for storing the tree like structure
    we are not storing anything at the 0th index,
    Parent  = k
    child = 2k, 2k+1

    insert : log(n) - insert the node at the last index and let it swim up to it's actual position
    delete : log(n) - delete the node at the first index and exchange it with the last element,
                      delete the last element and let the first node sink down to it's actual position

 */
public class BinaryHeap<T extends Comparable<T>> {

    T[] pq;
    int n = 0;

    public BinaryHeap(int capacity) {
        pq = (T[]) new Comparable[capacity + 1];
    }

    public void insert(T x) {
        pq[++n] = x;
        swim(n);
    }

    public T deleteMax() {
        T max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private void swim(int child) {
        while (child > 1 && less(child / 2, child)) {
            exch(child, child / 2);
            child = child / 2;
        }
    }

    private void sink(int parent) {
        while (2 * parent <= n) {
            int child = 2 * parent;
            if (child < n && less(child, child + 1)) {
                child++;
            }
            if (!less(parent, child)) {
                break;
            }
            exch(parent, child);
            parent = child;
        }
    }

    private void exch(int k, int i) {
        T t = pq[k];
        pq[k] = pq[i];
        pq[i] = t;
    }

    private boolean less(int i, int k) {
        return pq[i].compareTo(pq[k]) < 0;
    }

    public void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }
}
