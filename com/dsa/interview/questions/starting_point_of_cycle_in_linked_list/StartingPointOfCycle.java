package com.dsa.interview.questions.starting_point_of_cycle_in_linked_list;

/*
        Approach 1 :
            Using map
            Time complexity : O(N)
            Space complexity : O(N)

        Approach 2 :
            slow pointer and fast pointer
            if cycle found,
            count elements in loop
            move second pointer ahead by
            number of elements in loop,
            move slow and fast pointer at the same speed,
            where ever the pointers meet, that
            is the intersection element
            Time complexity : O(n)
            Space complexity : O(1)

        Approach 3 :
            slow pointer and fast pointer
            if cycle found,
            move the slow pointer to start and
            move both pointers at same speed,
            when they meet, it would be the
            point where cycle starts
            Time complexity : O(n)
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

public class StartingPointOfCycle {
    public Node startingPointOfCycle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                break;
            }
        }
        if (fastPointer == null || fastPointer.next == null)
            return null;

        int count = 1;
        slowPointer = slowPointer.next;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            count++;
        }
        slowPointer = head;
        fastPointer = head;
        while (count-- != 0) {
            fastPointer = fastPointer.next;
        }

        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }

    public Node startingPointOfCycleBestApproach(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                break;
            }
        }

        if (fastPointer == null || fastPointer.next == null)
            return null;

        slowPointer = head;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}
