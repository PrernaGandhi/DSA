package com.dsa.coursera_algo_part_1.sorts.quick_sort;

import com.dsa.coursera_algo_part_1.shuffling.Shuffling;
import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    Quicksort is implemented by first partitioning the array in such a way that
    all elements to the left of it is smaller than the pivot element,
    and all elements to the right of it is greater than the pivot element

    Example:
        S   O   R   T   E   X   A   M   P   L   E
        ^   ^                                   ^
        |   |                                   |
       low  i                                   j

        S   O   R   T   E   X   A   M   P   L   E
        ^           ^                           ^
        |           |                           |
       low          i                           j

       At this point element at i is greater than element at low
       and element at j is lower than element at low so we swap elements
       at i and j

        S   O   R   E   E   X   A   M   P   L   T
        ^           ^                           ^
        |           |                           |
       low          i                           j

        S   O   R   E   E   X   A   M   P   L   T
        ^                   ^               ^
        |                   |               |
       low                  i               j
       At this point element at i is greater than element at low
       and element at j is lower than element at low so we swap elements
       at i and j

        S   O   R   E   E   L   A   M   P   X   T
        ^                   ^               ^
        |                   |               |
       low                  i               j
        S   O   R   E   E   L   A   M   P   X   T
        ^                               ^   ^
        |                               |   |
       low                              j   i

      At this point i crossed j so we swap j and low
        P   O   R   E   E   L   A   M   S   X   T
        ^                               ^   ^
        |                               |   |
       low                              j   i

       Now elements before S are smaller than S
       and elements after S are greater than S

       Now we sort the individual halves and the array is sorted

 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        Shuffling<T> shuffling = new Shuffling<>();
        // shuffling is to improve performance
        shuffling.shuffle(elements);
        sort(elements, 0, elements.length - 1);
        return elements;
    }

    private void sort(T[] elements, int low, int high) {
        if (high <= low) {
            return;
        }

        int partition = partition(elements, low, high);
        sort(elements, low, partition - 1);
        sort(elements, partition + 1, high);
    }

    public int partition(T[] elements, int low, int high) {
        int i = low + 1;
        int j = high;

        while (true) {

            while (less(elements[i], elements[low])) {
                if (i == high) {
                    break;
                }
                i++;
            }
            while (less(elements[low], elements[j])) {
                if (j == low) {
                    break;
                }
                j--;
            }

            if (i >= j) {
                break;
            }

            exchange(elements, i, j);
        }
        exchange(elements, low, j);
        return j;
    }
}
