package com.dsa.priorityqueue;

public class Runner {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(10);
        priorityQueue.insert(20);
        priorityQueue.insert(30);
        priorityQueue.insert(40);
        priorityQueue.insert(50);
        priorityQueue.insert(60);
        priorityQueue.items.forEach(e -> System.out.print(e + " "));
        System.out.println();
        priorityQueue.insert(25);
        priorityQueue.items.forEach(e -> System.out.print(e + " "));
        System.out.println();
        priorityQueue.removeMin();
        priorityQueue.items.forEach(e -> System.out.print(e + " "));
    }
}
