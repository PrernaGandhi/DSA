package com.dsa.interview.questions.intersection_of_linked_list;

import java.util.HashSet;
import java.util.Set;

/*
               a1 -> a2
                        \
                        c1 -> c2 -> c3
                        /
          b1 -> b2 -> b3

          We can assume there is no cycles

          Approach 1 : Brute-force
            Iterate linked list 1 with one 2 as check in 2nd linked list
            Time complexity : O(M*N)
            Space complexity : O(1)

          Approach 2 : Map
            First we will iterate over the first list and
            store nodes in a set
            Now since we store nodes , 5-> 1, and 5->2,
            here both 5 are different as next pointer is different

            Time complexity : O(m + n)
            Space complexity : O(n)

         Approach 3 :
            Find length of linked list 1 : l1
            Find length of linked list 2 : l2
            Find difference : D = l1 - l2
            now move D steps ahead in the longer list
            Now both are equidistant from the intersection,
            if there exists any,
            Now move ahead in linked list

            Time complexity : O(m + n + m)
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

public class IntersectionOfLinkedList {

    public Node findIntersectionBruteforce(Node list1, Node list2) {

        while (list1 != null) {
            Node n = list2;
            while (n != null) {
                if (n == list1) {
                    return n;
                }
                n = n.next;
            }
            list1 = list1.next;
        }
        return null;
    }

    public Node findIntersectionMap(Node list1, Node list2) {
        Set<Node> set = new HashSet<>();
        while (list1 != null) {
            set.add(list1);
            list1 = list1.next;
        }

        while (list2 != null) {
            if (set.contains(list2)) {
                return list2;           // intersection point
            }
            list2 = list2.next;
        }
        return null;
    }

    public Node findIntersectionBestApproach(Node list1, Node list2) {

        if (list1 == null || list2 == null) {
            return null;
        }
        boolean isL1Greater = false;
        int l1 = 0;
        int l2 = 0;
        Node t1 = list1;
        Node t2 = list2;
        int diff = 0;
        // calculate length of list 1
        while (t1 != null) {
            l1++;
            t1 = t1.next;
        }

        // calculate length of list 2
        while (t2 != null) {
            l2++;
            t2 = t2.next;
        }

        if (l1 > l2) {
            isL1Greater = true;
            diff = l1 - l2;
        } else {
            diff = l2 - l1;
        }
        t1 = list1;
        t2 = list2;
        if (isL1Greater) {
            while (diff > 0) {
                t1 = t1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                t2 = t2.next;
                diff--;
            }
        }

        while (t1 != null && t2 != null) {
            if (t1 == t2) {
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }
}
