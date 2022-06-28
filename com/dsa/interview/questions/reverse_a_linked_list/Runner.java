package com.dsa.interview.questions.reverse_a_linked_list;


public class Runner {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.print(node1);
        Node reverseList = reverseLinkedList.reverse(node1);
        reverseLinkedList.print(reverseList);

    }
}
