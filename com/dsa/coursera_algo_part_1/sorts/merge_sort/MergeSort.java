package com.dsa.coursera_algo_part_1.sorts.merge_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    MergeSort involves splitting the array into half,
    sort the individual halves and merge them in sorted order

    M   E   R   G   E   S   O   R   T

    sort(MERG)
    sort(ESORT)

    E   G   M   R       E   O   R   S   T

    merge()

    E   G   M   R       E   O   R   S   T
    ^                   ^
    |                   |
    i                   j

    arr -> E

    E   G   M   R       E   O   R   S   T
        ^               ^
        |               |
        i               j

   arr -> E E
    E   G   M   R       E   O   R   S   T
        ^                   ^
        |                   |
        i                   j

   arr -> E E G
    E   G   M   R       E   O   R   S   T
            ^               ^
            |               |
            i               j

   arr -> E E G M
    E   G   M   R       E   O   R   S   T
                ^           ^
                |           |
                i           j

   arr -> E E G M O
    E   G   M   R       E   O   R   S   T
                ^               ^
                |               |
                i               j

   arr -> E E G M O R
    E   G   M   R       E   O   R   S   T
                  ^             ^
                  |             |
                  i             j
    since first half array is exhausted

    copy all elements from second half of array to the output array

   arr -> E E G M O R R S T


 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        int low = 0;
        int high = elements.length - 1;
        T[] copy = (T[]) new Comparable[elements.length];
        sort(elements, copy, low, high);
        return elements;
    }

    private void sort(T[] elements, T[] copy, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(elements, copy, low, mid);
        sort(elements,copy, mid + 1, high);
        merge(elements, copy, low, mid, high);
    }

    private void merge(T[] elements,T[] copy, int low, int mid, int high) {
        for (int index = low; index <= high; index++) {
            copy[index] = elements[index];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (less(copy[j], copy[i])) {
                elements[k] = copy[j];
                j++;
            } else {
                elements[k] = copy[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            elements[k] = copy[i];
            i++;
            k++;
        }
        while (j <= high) {
            elements[k] = copy[j];
            j++;
            k++;
        }
    }
}
