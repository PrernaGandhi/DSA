package com.dsa.interview.questions.k_sorted_array;

import java.util.Collections;
import java.util.PriorityQueue;

/*
        K sorted array
        Given a k sorted array and a value of k,
        we need to sort the array in decreasing order
        and each element in the array can only move
        k-1 or k+1 steps in the array to qualify as
        a k sorted array


        Example:
    =>      [10, 12, 15, 6, 9]
            k = 3
            after reverse sorting
            [15, 12, 10, 9, 6]

            now 10 moved 2 indices
            12 remained on the same index
            15 moved 2 indices
            6 moved 1 index
            9 moved 1 index

            all movement is less than k
            so it is a k sorted array


    =>      [10, 12, 6, 15, 9]
            k = 3
            after reverse sorting
            [15, 12, 10, 9, 6]

            now 10 moved 2 indices,
            12 remained on the same index
            6 moved 2 indices
            15 moved 3 indices, == k
            so it is not a k sorted array

            Approach 1:
                Bruteforce approach : Sort array with any sorting algorithm
                Time complexity : O(NlogN) -> mergeSort, quicksort, heapsort


            Approach 2:
                Maximum Priority Queue
                Time complexity : k*log k + (n - k)( log k + log k) + k*log k
                                : k*log k + (n - k)*log k + k*log k
                                : k*log k + n*log k - k*log k + k*log k
                                : k*log k + n*log k
                                : (k + n) * log k
                        when n>>>>>k
                        then  time complexity : O(n)

 */
public class KSortedArray {

    void kSortedArray(int[]arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        // k
        for (int i = 0; i <k; i++) {
            priorityQueue.add(arr[i]);  // log k
        }
        
        int start = 0;
        // n - k
        for (int i = k; i < arr.length; i++) {
            arr[start] = priorityQueue.peek();
            priorityQueue.poll();       // log k
            start++;
            priorityQueue.add(arr[i]);  // log k
        }

        // k
        while (!priorityQueue.isEmpty()) {
            arr[start] = priorityQueue.peek();
            priorityQueue.poll();       // log k
            start++;
        }
    }

}
