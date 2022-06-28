package com.dsa.interview.questions.mid_point_of_linked_list;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class MidPointOfLinkedList {

    public Node findMidpoint(Node list) {
        Node slowPointer = list;
        Node fastPointer = list;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
