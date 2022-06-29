package com.dsa.interview.questions.cycle_detection_in_linked_list;

/*
    Detect cycle in linked list

    Approach 1:
        Using set as we did to find intersection of linked list,
        iterate, if we have node in set, then found cycle,
        else if we have completed iterating over the list,
        no cycle found
        Time complexity : O(N)
        Space complexity : O(N)

    Approach 2:
        Slow and fast pointer approach
        fast pointer moves twice the speed of slow pointer
        Time complexity : O(N)
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

public class CycleDetectionInLinkedList {
    public boolean hasCycle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
