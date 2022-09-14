package com.dsa.coursera_algo_part_1.priority_queue;

public class Runner {

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
        maxPQ.insert(3);
        maxPQ.insert(1);
        maxPQ.insert(2);
        maxPQ.print();
        System.out.println(maxPQ.deleteMax());
        maxPQ.print();
        maxPQ.insert(12);
        maxPQ.insert(4);
        maxPQ.insert(7);
        maxPQ.insert(5);
        maxPQ.print();
        System.out.println(maxPQ.deleteMax());
        maxPQ.print();
    }
}
