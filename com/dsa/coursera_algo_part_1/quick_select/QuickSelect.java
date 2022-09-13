package com.dsa.coursera_algo_part_1.quick_select;

import com.dsa.coursera_algo_part_1.shuffling.Shuffling;
import com.dsa.coursera_algo_part_1.sorts.quick_sort.QuickSort;

/*
    We are trying to find the value at the k th position when sorted in ascending order

    We partition the array and then find out whether the position we are trying to find
    is in the first half or second and then we further partition that sub array,
    when the partition element index is equal to k, we found our element

    Time complexity is approximately linear
 */
public class QuickSelect<T extends Comparable<T>> {

    public T select(T[] elements, int k) {
        Shuffling<T> shuffling = new Shuffling<>();
        shuffling.shuffle(elements);
        int low = 0;
        int high = elements.length - 1;
        QuickSort<T> quickSort = new QuickSort<>();
        while (low <= high) {
            int partition = quickSort.partition(elements, low, high);
            if (partition < k) {
                low = partition + 1;
            } else if (partition > k) {
                high = partition - 1;
            } else {
                return elements[k];
            }
        }
        return elements[k];
    }

}
