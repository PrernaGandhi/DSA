package com.dsa.coursera_algo_part_1.sorts.shell_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    Shell sort has the same underlying sorting technique as insertion sort,
    the only difference being that we do that in different passes

    Example :
        S   O   R   T   E   X   A   M   P   L   E

        elements length (l) = 11
        h = (l - 1) / 3
        h = (11 - 1) / 3
        h = 3

        3 sort
        S   O   R   T   E   X   A   M   P   L   E
                    ^
                    |
                  h,i,j

            S   O   R   T   E   X   A   M   P   L   E
            ^           ^
            |           |
           j-h        h,i,j
           j-h < j, break

        S   O   R   T   E   X   A   M   P   L   E
            ^           ^
            |           |
           j-h        h,i,j
       j-h > j, exchange

            S   E   R   T   O   X   A   M   P   L   E
                ^           ^
                |           |
               j-h        h,i,j

        j = j - h
        now j-h < 0 < h
        so we move forward

        S   E   R   T   O   X   A   M   P   L   E
                ^           ^
                |           |
               j-h        h,i,j
        now j-h < j
        we move forward

        S   E   R   T   O   X   A   M   P   L   E
                    ^           ^
                    |           |
                   j-h        h,i,j
        j-h > j, exchange
            S   E   R   A   O   X   T   M   P   L   E
                        ^           ^
                        |           |
                       j-h        h,i,j
            now j = j - h
            S   E   R   A   O   X   T   M   P   L   E
            ^           ^           ^
            |           |           |
           j-h          j          h,i
           j-h > j, exchange
            A   E   R   S   O   X   T   M   P   L   E
            ^           ^           ^
            |           |           |
           j-h          j          h,i
       now we move forward
       A   E   R   S   O   X   T   M   P   L   E
                       ^           ^
                       |           |
                      j-h        h,i,j
        j-h > j, exchange
            j =j-h
           A   E   R   S   M   X   T   O   P   L   E
               ^           ^           ^
               |           |           |
              j-h          j          h,i
        now j-h < j, move  forward
        A   E   R   S   M   X   T   O   P   L   E
                            ^           ^
                            |           |
                           j-h        h,i,j
        now j-h > j, exchange
            A   E   R   S   M   P   T   O   X   L   E
                    ^           ^           ^
                    |           |           |
                   j-h          j          h,i
            j-h > j, exchange
            A   E   P   S   M   R   T   O   X   L   E
                    ^           ^           ^
                    |           |           |
                   j-h          j          h,i

        A   E   P   S   M   R   T   O   X   L   E
                                ^           ^
                                |           |
                               j-h        h,i,j
        j-h > j, exchange
            A   E   P   S   M   R   L   O   X   T   E
                        ^           ^           ^
                        |           |           |
                       j-h          j          h,i
            j-h > j, exchange
            A   E   P   L   M   R   S   O   X   T   E
                        ^           ^           ^
                        |           |           |
                       j-h          j          h,i
            A   E   P   L   M   R   S   O   X   T   E
            ^           ^                       ^
            |           |                       |
           j-h          j                      h,i

           j-h < j, move forward
        A   E   P   L   M   R   S   O   X   T   E
                                    ^           ^
                                    |           |
                                   j-h        h,i,j
        j-h > j, exchange
            A   E   P   L   M   R   S   E   X   T   O
                            ^           ^           ^
                            |           |           |
                           j-h          j          h,i
        j-h > j, exchange
            A   E   P   L   E   R   S   M   X   T   O
                ^           ^                       ^
                |           |                       |
               j-h          j                      h,i
        j-h < j, move forward

        h=h/3
        h=3/3
        h=1

        1 sort
        A   E   P   L   E   R   S   M   X   T   O
        ^   ^
        |   |
       j-h h,i,j
       j-h < j, move forward

        A   E   P   L   E   R   S   M   X   T   O
            ^   ^
            |   |
           j-h h,i,j
       j-h < j, move forward
        A   E   P   L   E   R   S   M   X   T   O
                ^   ^
                |   |
               j-h h,i,j
            j-h > j, exchange
            A   E   L   P   E   R   S   M   X   T   O
                ^   ^   ^
                |   |   |
               j-h  j h,i,j
         j-h < j, move forward
        A   E   L   P   E   R   S   M   X   T   O
                    ^   ^
                    |   |
                   j-h h,i,j
            j-h > j, exchange
            A   E   L   E   P   R   S   M   X   T   O
                    ^   ^   ^
                    |   |   |
                   j-h  j h,i,j
            j-h > j, exchange
            A   E   E   L   P   R   S   M   X   T   O
                ^   ^       ^
                |   |       |
               j-h  j     h,i,j
        A   E   E   L   P   R   S   M   X   T   O
                        ^   ^
                        |   |
                       j-h h,i,j
         j-h<j, move forward

        A   E   E   L   P   R   S   M   X   T   O
                            ^   ^
                            |   |
                          j-h h,i,j
        j-h<j, move forward

        A   E   E   L   P   R   S   M   X   T   O
                                ^   ^
                                |   |
                              j-h h,i,j
       j-h>j, exchange
            A   E   E   L   P   R   M   S   X   T   O
                                ^   ^   ^
                                |   |   |
                              j-h   j  h,i
       j-h>j, exchange
            A   E   E   L   P   M   R   S   X   T   O
                            ^   ^       ^
                            |   |       |
                          j-h   j      h,i
       j-h>j, exchange
            A   E   E   L   M   P   R   S   X   T   O
                        ^   ^           ^
                        |   |           |
                       j-h   j         h,i
         j-h < j, move forward

        A   E   E   L   M   P   R   S   X   T   O
                                    ^   ^
                                    |   |
                                   j-h h,i,j
         j-h < j, move forward

        A   E   E   L   M   P   R   S   X   T   O
                                        ^   ^
                                        |   |
                                       j-h h,i,j
        j-h >j, exchange

            A   E   E   L   M   P   R   S   T   X   O
                                        ^   ^   ^
                                        |   |   |
                                       j-h  j  h,i

       j-h<j, move forward
       A   E   E   L   M   P   R   S   T   X   O
                                           ^   ^
                                           |   |
                                          j-h  h,i,j

           A   E   E   L   M   P   R   S   T   O   X
                                           ^   ^   ^
                                           |   |   |
                                          j-h  j  h,i
       j-h>j, exchange
           A   E   E   L   M   P   R   S   O   T   X
                                       ^   ^       ^
                                       |   |       |
                                      j-h  j      h,i

       j-h>j, exchange
           A   E   E   L   M   P   R   O   S   T   X
                                   ^   ^           ^
                                   |   |           |
                                  j-h  j          h,i
       j-h>j, exchange
           A   E   E   L   M   P   O   R   S   T   X
                               ^   ^               ^
                               |   |               |
                              j-h  j              h,i
       j-h>j, exchange
           A   E   E   L   M   O   P   R   S   T   X
                           ^   ^                   ^
                           |   |                   |
                          j-h  j                  h,i

 */
public class ShellSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        int h = (elements.length - 1) / 3;
        while (h >= 1) {
            for (int i = h; i < elements.length; i++) {
                int j = i;
                while (j >= h) {
                    if (less(elements[j], elements[j - h])) {
                        exchange(elements, j, j - h);
                    } else {
                        break;
                    }
                    j = j - h;
                }
            }
            h = h / 3;
        }
        return elements;
    }
}
