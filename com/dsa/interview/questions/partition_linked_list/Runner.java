package com.dsa.interview.questions.partition_linked_list;

public class Runner {
    public static void main(String[] args) {
        Node node6 = new Node(2, null);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(2, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(4, node3);
        Node node1 = new Node(1, node2);

        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();
        partitionLinkedList.print(node1);
        Node head = partitionLinkedList.partition(node1, 3);
        partitionLinkedList.print(head);
    }
}
