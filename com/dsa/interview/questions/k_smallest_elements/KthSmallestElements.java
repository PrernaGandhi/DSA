package com.dsa.interview.questions.k_smallest_elements;

import java.util.Collections;
import java.util.PriorityQueue;

/*
        [8, 5, 12, 10, 0, 1, 6, 9]

        Find k smallest items

        Approach 1: Sort the array
                Time complexity : O(Nlog N)

        Approach 2 : Max priority queue
 */
public class KthSmallestElements {

    void findKSmallestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);     // log k
        }

        // n - k
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                pq.remove(); // log k
                pq.add(arr[i]); // log k
            }
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
