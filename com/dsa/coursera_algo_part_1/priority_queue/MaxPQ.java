package com.dsa.coursera_algo_part_1.priority_queue;

public class MaxPQ<T extends Comparable<T>> {

    private final T[] pq;
    private int n;

    public MaxPQ(int capacity) {
        pq = (T[]) new Comparable[capacity];
    }

    void insert(T v) {
        pq[n++] = v;
    }

    T deleteMax() {
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
        T temp = pq[max];
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
