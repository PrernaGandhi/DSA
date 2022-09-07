package com.dsa.coursera_algo_part_1.queues.resizing_arrays;

public class Runner {

    public static void main(String[] args) {
        ArrayBasedQueue<Integer> arrayBasedQueue = new ArrayBasedQueue<>();
        arrayBasedQueue.enqueue(12);
        arrayBasedQueue.enqueue(10);
        arrayBasedQueue.enqueue(14);

        // 12 10 14
        arrayBasedQueue.print();

        arrayBasedQueue.dequeue();

        // 10 14
        arrayBasedQueue.print();

        arrayBasedQueue.enqueue(20);
        arrayBasedQueue.enqueue(30);

        // 10 14 20 30
        arrayBasedQueue.print();

        arrayBasedQueue.dequeue();

        // 14 20 30
        arrayBasedQueue.print();
    }

}
