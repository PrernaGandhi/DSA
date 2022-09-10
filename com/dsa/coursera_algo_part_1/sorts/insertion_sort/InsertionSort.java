package com.dsa.coursera_algo_part_1.sorts.insertion_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    Insertion sort works on the premise that the elements on the left are already sorted and
    as we encounter a new element, we sort elements to the left

    Example :

        i
        |
        v
        7   10  5   3   8   4   2   9   6
        ^
        |
        j


            i
            |
            v
        7   10  5   3   8   4   2   9   6
        ^    ^
        |    |
       j-1   j

        j > j-1, break

                i
                |
                v
        7   10  5   3   8   4   2   9   6
            ^   ^
            |   |
           j-1  j

                j < j - 1, swap
                        i
                        |
                        v
                7   5   10  3   8   4   2   9   6
                ^   ^
                |   |
               j-1  j

                j < j - 1, swap
                        i
                        |
                        v
                5   7   10  3   8   4   2   9   6
                ^
                |
                j

                    i
                    |
                    v
        5   7   10  3   8   4   2   9   6
                ^   ^
                |   |
               j-1  j
        j < j-1, swap
                            i
                            |
                            v
                5   7   3  10   8   4   2   9   6
                    ^   ^
                    |   |
                   j-1  j
                j < j-1, swap
                            i
                            |
                            v
                5   3   7  10   8   4   2   9   6
                ^   ^
                |   |
               j-1  j
               j < j-1, swap
                            i
                            |
                            v
                3   5   7  10   8   4   2   9   6
                ^
                |
                j


                        i
                        |
                        v
        3   5   7  10   8   4   2   9   6
                    ^   ^
                    |   |
                   j-1  j
                j < j-1, swap
                                i
                                |
                                v
                3   5   7   8   10   4   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                 j > j -1, break

                            i
                            |
                            v
        3   5   7  10   8   4   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap
                                i
                                |
                                v
                3   5   7  10   4   8   2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap
                                i
                                |
                                v
                3   5   7   4  10   8   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap
                               i
                               |
                               v
                3   5   4   7  10   8   2   9   6
                    ^   ^
                    |   |
                   j-1  j
                j<j-1, swap
                               i
                               |
                               v
                3   4   5   7  10   8   2   9   6
                ^   ^
                |   |
               j-1  j
                               i
                               |
                               v
                3   4   5   7  10   8   2   9   6
                ^
                |
                j

                            i
                            |
                            v
        3   4   5   7  10   8   2   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap
                                    i
                                    |
                                    v
                3   4   5   7   8   10   2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap
                                    i
                                    |
                                    v
                3   4   5   7   8   10   2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j>j-1, break

                                i
                                |
                                v
        3   4   5   7   8   10  2   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap
                                        i
                                        |
                                        v
                3   4   5   7   8   2   10   9   6
                                ^   ^
                                |   |
                               j-1  j
                j<j-1, swap
                                        i
                                        |
                                        v
                3   4   5   7   2   8   10   9   6
                            ^   ^
                            |   |
                           j-1  j
                j<j-1, swap
                                        i
                                        |
                                        v
                3   4   5   2   7   8   10   9   6
                        ^   ^
                        |   |
                       j-1  j
                j<j-1, swap
                                        i
                                        |
                                        v
                3   4   2   5   7   8   10   9   6
                    ^   ^
                    |   |
                   j-1  j
                j<j-1, swap
                                        i
                                        |
                                        v
                2   3   4   5   7   8   10   9   6
                ^   ^
                |   |
               j-1  j
               j > 0, false, break
                                        i
                                        |
                                        v
                2   3   4   5   7   8   10   9   6
                ^
                |
                j

                                    i
                                    |
                                    v
        2   3   4   5   7   8   10  9   6
                                ^   ^
                                |   |
                               j-1  j
                j<j-1, swap
                                            i
                                            |
                                            v
                2   3   4   5   7   8   9   10   6
                                    ^   ^
                                    |   |
                                   j-1  j
                j > j-1, break

                                         i
                                         |
                                         v
        2   3   4   5   7   8   9   10   6
                                     ^   ^
                                     |   |
                                    j-1  j
                j<j-1, swap
                                                i
                                                |
                                                v
                2   3   4   5   7   8   9   6   10
                                        ^   ^
                                        |   |
                                       j-1  j
                j<j-1, swap
                                                i
                                                |
                                                v
                2   3   4   5   7   8   6   9   10
                                    ^   ^
                                    |   |
                                   j-1  j
                j<j-1, swap
                                                i
                                                |
                                                v
                2   3   4   5   7   6   8   9   10
                                ^   ^
                                |   |
                               j-1  j

                j<j-1, swap
                                                i
                                                |
                                                v
                2   3   4   5   6   7   8   9   10
                            ^   ^
                            |   |
                           j-1  j
                j > j-1, break
                                                i
                                                |
                                                v
                2   3   4   5   6   7   8   9   10
                            ^   ^
                            |   |
                           j-1  j

 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int j = i;
            while (j > 0) {
                if (less(elements[j], elements[j - 1])) {
                    exchange(elements, j, j -1);
                } else {
                    break;
                }
                j--;
            }
        }
        return elements;
    }
}
