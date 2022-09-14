package com.dsa.coursera_algo_part_1.priority_queue;

public class MaxPQ<Key extends Comparable<Key>> {

    private final Key[] pq;
    private int n;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    void insert(Key v) {
        pq[n++] = v;
    }

    Key deleteMax() {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, n - 1);
        return pq[--n];
    }

    private void exch(int max, int i) {
        Key temp = pq[max];
        pq[max] = pq[i];
        pq[i] = temp;
    }

    private boolean less(int max, int i) {
        return pq[max].compareTo(pq[i]) < 0;
    }

    boolean isEmpty() {
        return n == 0;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }
}
