package com.dsa.coursera_algo_part_1.queues;

public interface Queue<T> {

    void enqueue(T data);

    T dequeue();

    boolean isEmpty();
    void print();
}
