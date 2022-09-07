package com.dsa.coursera_algo_part_1.stacks.linked_list;

public class Runner {

    public static void main(String[] args) {
        LinkedListBasedStack<Integer> linkedListBasedStack = new LinkedListBasedStack<>();
        linkedListBasedStack.push(12);
        linkedListBasedStack.push(10);
        linkedListBasedStack.push(14);

        // 14 10 12
        linkedListBasedStack.print();

        System.out.println("Top element of stack : " + linkedListBasedStack.top());
        linkedListBasedStack.pop();

        // 10 12
        linkedListBasedStack.print();

        linkedListBasedStack.push(20);
        linkedListBasedStack.push(30);

        // 30 20 10 12
        linkedListBasedStack.print();

        System.out.println("Top element of stack : " + linkedListBasedStack.top());
        linkedListBasedStack.pop();

        // 20 10 12
        linkedListBasedStack.print();
    }

}
