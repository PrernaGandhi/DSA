package com.dsa.interview.questions.reverse_a_linked_list;

/*
        Reverse a linked list
        1 -> 2 -> 3 -> 4 -> 5 -> null
        5 -> 4 -> 3 -> 2 -> 1 -> null

        Suppose we have already reversed a part of the list

                   prev         curr       n
         __        __            __       __      __
        |__| <--- |__|          |__| --> |__| -> |__|

        Now we save current's next into node n
        n = curr.next

        now curr next should point to prev,
        curr.next = prev

        now current becomes the previous
        prev = curr

        and the current's next of the original node
        becomes the new current now
        curr = n
 */
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class ReverseLinkedList {
    public Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }

    public void print(Node node1) {
        Node temp = node1;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
