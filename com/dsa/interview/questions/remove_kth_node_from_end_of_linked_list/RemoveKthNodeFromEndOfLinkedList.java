package com.dsa.interview.questions.remove_kth_node_from_end_of_linked_list;

/*
        We take two pointers, slow and fast,
        now move fast pointer k times,
        now when fast pointer reaches null,
        we reach the desired node to be deleted

        Time complexity : O(k + N - k) = O(N)
        Space complexity : O(1)
 */
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class RemoveKthNodeFromEndOfLinkedList {
    public Node remove(Node list, int k) {
        Node slow = list;
        Node fast = list;

        while (k >= 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {     // k is l1
            return slow.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // delete k th node from end
        slow.next = slow.next.next;

        return list;
    }

    public void print(Node node1) {
        while (node1 != null) {
            System.out.print(node1.data + " -> ");
            node1 = node1.next;
        }
        System.out.println("null");
    }
}
