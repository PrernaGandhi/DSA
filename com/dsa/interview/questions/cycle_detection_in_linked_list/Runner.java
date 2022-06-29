package com.dsa.interview.questions.cycle_detection_in_linked_list;

public class Runner {
    public static void main(String[] args) {
        Node node9 = new Node(9, null);
        Node node8 = new Node(2, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(3, node7);
        Node node5 = new Node(2, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(9, node4);
        Node node2 = new Node(1, node3);
        Node node1 = new Node(8, node2);

        CycleDetectionInLinkedList detection = new CycleDetectionInLinkedList();
        System.out.println(detection.hasCycle(node1));

        node9.next = node6;
        System.out.println(detection.hasCycle(node1));
    }
}
