package com.dsa.inplace.heapsort;

/*
        10  5   8   1   4

        Min heap --->   check if it is complete binary tree (CBT)
                        complete binary tree is all element filled
                        except the last level as below
                            o                 o                   o
                           / \              /   \               /   \
                          o   o            o      o            o     o
                         / \             /   \   /  \        /  \   /
                        o   o           o     o o    o      o    o o

                        but all the elements should be
                        added in order left, than right,
                        so below is not a complete binary tree.

                            o                     o               o
                          /   \                 /   \           /   \
                         o     o               o     o         o     o
                       /      /  \            /     /         /       \
                      o      o    o          o     o         o         o


                        minimum element to be at the top
                        root element is less than the children element


        Min heap
        then remove min element n times

        Time complexity : O(NlogN)
        Space complexity : O(1)


    1.  Make min heap
            assume we have only one
            element in our heap, i.e, 10
                    10
            then add 5,
                    10
                   /
                  5
            check if parent of 5,i.e, 10 < 5, no
            swap 5 and 10
                    5
                  /
                10
            then add 8,
                    5
                  /   \
                10     8
            check if parent of 8,i.e, 5 < 8, yes
            do nothing
                    5
                  /   \
                10     8
            then add 1,
                    5
                  /   \
                10     8
               /
              1
            then check if parent of 1,i.e, 10 < 1, no
            swap 10 and 1
                    5
                  /   \
                1      8
               /
             10
            then check if parent of 1,i.e, 5 < 1, no
            swap 5 and 1
                    1
                  /   \
                5      8
               /
             10
            then add 4,
                    1
                  /   \
                 5     8
               /  \
             10    4
            then check if parent of 4,i.e, 10 < 1, no
            swap 10 and 4
                    1
                  /   \
                 5     8
               /  \
             10    4
            then check if parent of 4,i.e, 5 < 1, no
            swap 10 and 4
                    1
                  /   \
                 4     8
               /  \
             10    5

    2.  then remove min element N times
                    1
                  /   \
                 4     8
               /  \
             10    5
            remove min element, i.e, 1
            swap last element and min element, i.e, 5 and 1
                    5
                  /   \
                 4     8
               /  \
             10    1
            check if children are greater than 5, 4 and 8 > 5, no
            swap with least element, swap 5 and 4
                    4
                  /   \
                 5     8
               /  \
             10    1
            now we don't remove 1, but consider it not as a part of the array

            Now remove the next small element,i.e, 4
                    4
                  /   \
                 5     8
               /  \
             10    1
            swap 4 with last element,i.e, 10 not 1 as 1 is no longer part of the array
                    10
                  /   \
                 5     8
               /  \
              4    1
            now check if the children of 10 is greater than 10, i.e, 5 and 8 > 10, no
            swap with the least element,i.e, 5
                    5
                  /   \
                10     8
               /  \
              4    1
            now 4 is also removed

            now remove the next small element,i.e, 5
                    5
                  /   \
                10     8
               /  \
              4    1
            swap with the last element,i.e, 8
                    8
                  /   \
                10     5
               /  \
              4    1
            now check if children of 10 are smaller than 10,i.e 8 > 10, no
            swap 10 and 8
                    8
                  /   \
                10     5
               /  \
              4    1
            now 5 is also removed, only elements we have are 8 and 10

            now to remove 8, swap with the last element,i.e, 10
                    10
                  /    \
                 8      5
               /  \
              4    1
             now the only element we have is 10,


             now the array looks like :
                10 8 5 4 1,
            now it is reverse sorted

        Time complexity : O(NlogN)
        Space complexity : O(1)
 */
public class HeapSort {
    // O(NlogN)
    private void minHeap(int[] arr) {
        // N
        for (int i = 1; i < arr.length; i++) {
            int childIndex = i;
            // logN
            while (childIndex > 0) {
                int parentIndex = (childIndex - 1) / 2;
                if (arr[parentIndex] > arr[childIndex]) {
                    swap(arr, childIndex, parentIndex);
                    childIndex = parentIndex;
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] arr, int childIndex, int parentIndex) {
        int temp = arr[childIndex];
        arr[childIndex] = arr[parentIndex];
        arr[parentIndex] = temp;
    }

    public void sort(int[] arr) {
        // NlogN
        minHeap(arr);
        // N
        for (int i = 0; i < arr.length; i++) {
            removeMin(arr, arr.length - i - 1);
        }
    }

    private void removeMin(int[] arr, int end) {
        swap(arr, 0, end);
        int parentIndex = 0;

        while (parentIndex < end) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            // since we don't remove the last index, we make sure
            // if the last element is child index, then we don't
            // consider it as it is removed, but still part of the array
            if (leftChildIndex >= end || rightChildIndex >= end) {
                break;
            }
            if (arr[leftChildIndex] < arr[parentIndex] || arr[rightChildIndex] < arr[parentIndex]) {
                int val = Math.min(arr[leftChildIndex], arr[rightChildIndex]);
                if (val == arr[leftChildIndex]) {
                    swap(arr, leftChildIndex, parentIndex);
                    parentIndex = leftChildIndex;
                } else {
                    swap(arr, rightChildIndex, parentIndex);
                    parentIndex = rightChildIndex;
                }
            } else {
                break;
            }
        }
    }
}
