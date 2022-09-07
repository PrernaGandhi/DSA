package com.dsa.coursera_algo_part_1.stacks.resizing_arrays;

public class Runner {

    public static void main(String[] args) {
        ArrayBasedStack<Integer> arrayBasedStack = new ArrayBasedStack<>();
        arrayBasedStack.push(12);
        arrayBasedStack.push(10);
        arrayBasedStack.push(14);

        // 12 10 14
        arrayBasedStack.print();

        System.out.println("Top Element of stack : " + arrayBasedStack.top());
        arrayBasedStack.pop();

        // 12 10
        arrayBasedStack.print();

        arrayBasedStack.push(20);
        arrayBasedStack.push(30);

        // 12 10 20 30
        arrayBasedStack.print();

        System.out.println("Top Element of stack : " + arrayBasedStack.top());
        arrayBasedStack.pop();

        // 12 10 20
        arrayBasedStack.print();
    }

}
