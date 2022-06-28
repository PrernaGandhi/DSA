package com.dsa.interview.questions.remove_kth_node_from_end_of_linked_list;


public class Runner {
    public static void main(String[] args) {
        Node node10 = new Node(10, null);
        Node node9 = new Node(9, node10);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        RemoveKthNodeFromEndOfLinkedList removeKthNodeFromEndOfLinkedList = new RemoveKthNodeFromEndOfLinkedList();
        removeKthNodeFromEndOfLinkedList.print(node1);
        Node head = removeKthNodeFromEndOfLinkedList.remove(node1, 4);
        removeKthNodeFromEndOfLinkedList.print(head);

        node4 = new Node(4, null);
        node3 = new Node(3, node4);
        node2 = new Node(2, node3);
        node1 = new Node(1, node2);

        removeKthNodeFromEndOfLinkedList.print(node1);
        head = removeKthNodeFromEndOfLinkedList.remove(node1, 4);
        removeKthNodeFromEndOfLinkedList.print(head);

        node4 = new Node(4, null);
        node3 = new Node(3, node4);
        node2 = new Node(2, node3);
        node1 = new Node(1, node2);

        removeKthNodeFromEndOfLinkedList.print(node1);
        head = removeKthNodeFromEndOfLinkedList.remove(node1, 1);
        removeKthNodeFromEndOfLinkedList.print(head);

    }
}
