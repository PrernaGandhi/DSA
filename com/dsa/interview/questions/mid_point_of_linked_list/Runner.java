package com.dsa.interview.questions.mid_point_of_linked_list;

public class Runner {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        MidPointOfLinkedList midPointOfLinkedList = new MidPointOfLinkedList();
        System.out.println(midPointOfLinkedList.findMidpoint(node1).data);
        Node node6 = new Node(6, null);
        node5 = new Node(5, node6);
        node4 = new Node(4, node5);
        node3 = new Node(3, node4);
        node2 = new Node(2, node3);
        node1 = new Node(1, node2);
        System.out.println(midPointOfLinkedList.findMidpoint(node1).data);
    }
}
