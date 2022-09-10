package com.dsa.coursera_algo_part_1.sorts.selection_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    Selection sort works by finding the smallest element to the right and exchanging with the current index

    Example :
        7   10  5   3   8   4   2   9   6
        ^
        |
       i,j

            find the smallest element
                7   10  5   3   8   4   2   9   6
                ^                       ^
                |                       |
                i                       j

            exchange
                2   10  5   3   8   4   7   9   6
                ^                       ^
                |                       |
                i                       j


        2   10  5   3   8   4   7   9   6
            ^
            |
            i,j

            find the smallest element
                2   10  5   3   8   4   7   9   6
                    ^       ^
                    |       |
                    i       j

            exchange
                2   3   5   10   8   4   7   9   6
                    ^       ^
                    |       |
                    i       j

        2   3   5   10   8   4   7   9   6
                ^
                |
                i,j

            find the smallest element
                2   3   5   10   8   4   7   9   6
                        ^            ^
                        |            |
                        i            j

            exchange
                2   3   4   10   8   5   7   9   6
                        ^            ^
                        |            |
                        i            j

        2   3   4   10   8   5   7   9   6
                    ^
                    |
                    i,j

            find the smallest element
                2   3   4   10   8   5   7   9   6
                            ^        ^
                            |        |
                            i        j

            exchange
                2   3   4   5   8   10   7   9   6
                        ^            ^
                        |            |
                        i            j

        2   3   4   5   8   10   7   9   6
                        ^
                        |
                        i,j

            find the smallest element
                2   3   4   5   8   10   7   9   6
                                ^                ^
                                |                |
                                i                j

            exchange
                2   3   4   5   6   10   7   9   8
                                ^                ^
                                |                |
                                i                j

        2   3   4   5   6   10   7   9   8
                             ^
                             |
                            i,j

            find the smallest element
                2   3   4   5   6   10   7   9   8
                                    ^    ^
                                    |    |
                                    i    j

            exchange
                2   3   4   5   6   7   10   9   8
                                    ^    ^
                                    |    |
                                    i    j


        2   3   4   5   6   7   10   9   8
                                ^
                                |
                                i,j

            find the smallest element
                2   3   4   5   6   7   10   9   8
                                        ^        ^
                                        |        |
                                        i        j

            exchange
                2   3   4   5   6   7   8   9   10
                                        ^        ^
                                        |        |
                                        i        j

        2   3   4   5   6   7   8   9   10
                                    ^
                                    |
                                    i,j

            find the smallest element
                2   3   4   5   6   7   8   9   10
                                            ^
                                            |
                                            i,j

            exchange
                2   3   4   5   6   7   8   9   10
                                            ^
                                            |
                                            i,j

        2   3   4   5   6   7   8   9   10
                                         ^
                                         |
                                        i,j

            find the smallest element
                2   3   4   5   6   7   8   9   10
                                                 ^
                                                 |
                                                i,j

            exchange
                2   3   4   5   6   7   8   9   10
                                                 ^
                                                 |
                                                i,j


 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (less(elements[j], elements[smallestIndex])) {
                    smallestIndex = j;
                }
            }
            exchange(elements, i, smallestIndex);
        }
        return elements;
    }
}
