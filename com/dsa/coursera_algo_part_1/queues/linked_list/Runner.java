package com.dsa.coursera_algo_part_1.queues.linked_list;

public class Runner {

    public static void main(String[] args) {
        LinkedListBasedQueue<Integer> linkedListBasedQueue = new LinkedListBasedQueue<>();
        linkedListBasedQueue.enqueue(12);
        linkedListBasedQueue.enqueue(10);
        linkedListBasedQueue.enqueue(14);

        // 12 10 14
        linkedListBasedQueue.print();

        linkedListBasedQueue.dequeue();

        // 10 14
        linkedListBasedQueue.print();

        linkedListBasedQueue.enqueue(20);
        linkedListBasedQueue.enqueue(30);

        // 10 14 20 30
        linkedListBasedQueue.print();

        linkedListBasedQueue.dequeue();

        // 14 20 30
        linkedListBasedQueue.print();
    }

}
