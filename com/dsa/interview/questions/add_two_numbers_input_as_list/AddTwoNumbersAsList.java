package com.dsa.interview.questions.add_two_numbers_input_as_list;

/*
        Linked List 1 : 2 -> 4 -> 3         Number = 342
        Linked List 2 : 5 -> 6 -> 4         Number = 465
        Output  :   7 -> 0 -> 8             Sum = 807


        Cases :
            Case 1 :
                Length of one linked list greater than another
                    2 -> 4 -> 3 -> 7
                    5 -> 6 -> 4

 */
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class AddTwoNumbersAsList {
    public Node sum(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        int carry = 0;

        Node head = null;

        while (n1 != null && n2 != null) {
            int sum = n1.data + n2.data + carry;
            head = new Node(sum % 10, head);
            carry = sum / 10;
            n1 = n1.next;
            n2 = n2.next;
        }
        while (n1 != null) {
            int sum = n1.data + carry;
            head = new Node(sum % 10, head);
            carry = sum / 10;
            n1 = n1.next;
        }
        while (n2 != null) {
            int sum = n2.data + carry;
            head = new Node(sum % 10, head);
            carry = sum / 10;
            n2 = n2.next;
        }

        if (carry > 0) {
            head = new Node(carry, head);
        }

        // reverse the linked list
        return reverse(head);
    }

    private Node reverse(Node n) {
        Node curr = n;
        Node prev = null;

        while (curr != null) {
            Node node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        return prev;
    }

    public void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
