package com.dsa.interview.questions.intersection_of_linked_list;

public class Runner {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node node6 = new Node(12, node3);
        Node node7 = new Node(11, node6);
        Node node8 = new Node(10, node7);

        IntersectionOfLinkedList intersectionOfLinkedList = new IntersectionOfLinkedList();
        Node intersection = intersectionOfLinkedList.findIntersectionBruteforce(node1, node8);
        System.out.println(intersection != null ? intersection.data : null);

        intersection = intersectionOfLinkedList.findIntersectionMap(node1, node8);
        System.out.println(intersection != null ? intersection.data : null);

        intersection = intersectionOfLinkedList.findIntersectionBestApproach(node1, node8);
        System.out.println(intersection != null ? intersection.data : null);

        System.out.println();

        node6 = new Node(12, null);
        node7 = new Node(11, node6);
        node8 = new Node(10, node7);

        intersection = intersectionOfLinkedList.findIntersectionBruteforce(node1, node8);
        System.out.println(intersection != null ? intersection.data : null);

        intersection = intersectionOfLinkedList.findIntersectionMap(node1, node8);
        System.out.println(intersection != null ? intersection.data : null);

        intersection = intersectionOfLinkedList.findIntersectionBestApproach(node1, node8);
        System.out.println(intersection != null ? intersection.data : null);

    }
}
