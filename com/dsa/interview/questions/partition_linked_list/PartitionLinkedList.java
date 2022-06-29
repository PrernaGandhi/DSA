package com.dsa.interview.questions.partition_linked_list;

/*
    Input : 1 -> 4 -> 3 -> 2 -> 5 -> 2

    x = 3

    So all the values less than the x should come before

    Output :    1 -> 2 -> 2 -> 4 -> 3 -> 5

    We need to preserve the original order
    which means 1 -> 2 -> 2 -> 3 -> 4 -> 5 wouldn't
    be considered as a valid output as in
    the original list 4 comes before 3 and
    hence the order should be preserved

 */

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class PartitionLinkedList {
    public Node partition(Node head, int x) {
        Node leftHead = null;
        Node leftTail = null;
        Node rightHead = null;
        Node rightTail = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data < x) {
                if (leftHead == null) {
                    leftHead = curr;
                    leftTail = curr;
                } else {
                    // insert at tail
                    leftTail.next = curr;

                    leftTail = curr;
                }
            } else {
                if (rightHead == null) {
                    rightHead = curr;
                    rightTail = curr;
                } else {
                    // insert at tail
                    rightTail.next = curr;

                    rightTail = curr;
                }
            }
            curr = curr.next;
        }

        // left and right are ready
        // otherwise cycle is formed
        // left : l1->l2->l3
        // right : r1->r2->r3->l1
        // now in the else part we are doing
        // left tail.next = right head
        // then we l3 points to r1,
        // so cycle is formed
        // since we are copying the nodes
        // from the original list, it isn't set to null
        leftTail.next = null;
        rightTail.next = null;

        if (rightHead != null && leftHead == null) {
            return rightHead;
        } else if (leftHead != null && rightHead == null) {
            return leftHead;
        } else {
            // joining the left and the right sub lists
            leftTail.next = rightHead;
            return leftHead;
        }
    }

    public void print(Node node1) {
        while (node1 != null) {
            System.out.print(node1.data + " -> ");
            node1 = node1.next;
        }
        System.out.println("null");
    }
}
