package com.dsa.interview.questions.add_two_numbers_input_as_list;


public class Runner {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node node6 = new Node(9, null);
        Node node7 = new Node(9, node6);
        Node node8 = new Node(9, node7);
        Node node9 = new Node(9, node8);
        Node node10 = new Node(9, node9);

        AddTwoNumbersAsList addTwoNumbersAsList = new AddTwoNumbersAsList();
        addTwoNumbersAsList.print(node1);
        addTwoNumbersAsList.print(node10);
        Node head = addTwoNumbersAsList.sum(node1, node10);
        addTwoNumbersAsList.print(head);

    }
}
