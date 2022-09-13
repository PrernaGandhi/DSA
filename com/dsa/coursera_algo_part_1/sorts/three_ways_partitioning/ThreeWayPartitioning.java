package com.dsa.coursera_algo_part_1.sorts.three_ways_partitioning;

import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    Three way partitioning is for sorting arrays with duplicate keys
    lt,i                                                              gt
     |                                                                |
     v                                                                v
    "P", "A", "B", "X", "W", "P", "P", "V", "P", "D", "P", "C", "Y", "Z"
     ^                                                                ^
     |                                                                |
    low                                                              high
    lt    i                                                           gt
     |    |                                                           |
     v    v                                                           v
    "P", "A", "B", "X", "W", "P", "P", "V", "P", "D", "P", "C", "Y", "Z"
     ^                                                                ^
     |                                                                |
    low                                                              high

   now element at i is less than pivot(lt) element so exchange i and lt
         lt    i                                                     gt
          |    |                                                      |
          v    V                                                      v
    "A", "P", "B", "X", "W", "P", "P", "V", "P", "D", "P", "C", "Y", "Z"
     ^                                                                ^
     |                                                                |
    low                                                              high
   now element at i is less than pivot(lt) element so exchange i and lt
              lt    i                                                 gt
               |    |                                                 |
               v    v                                                 v
    "A", "B", "P", "X", "W", "P", "P", "V", "P", "D", "P", "C", "Y", "Z"
     ^                                                                ^
     |                                                                |
    low                                                              high

    now element at i is greater than pivot(lt) element so exchange i with gt
              lt    i                                           gt
               |    |                                            |
               v    v                                            v
    "A", "B", "P", "Z", "W", "P", "P", "V", "P", "D", "P", "C", "Y", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high
    now element at i is greater than pivot(lt) element so exchange i with gt
              lt    i                                      gt
               |    |                                       |
               v    v                                       v
    "A", "B", "P", "Y", "W", "P", "P", "V", "P", "D", "P", "C", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high
    now element at i is greater than pivot(lt) element so exchange i with gt
              lt    i                                 gt
               |    |                                  |
               v    v                                  v
    "A", "B", "P", "C", "W", "P", "P", "V", "P", "D", "P", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high

    now element at i is less than pivot(lt) element so exchange lt and i
                  lt,i                                gt
                    |                                  |
                    v                                  v
    "A", "B", "C", "P", "W", "P", "P", "V", "P", "D", "P", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high

    now element at i is equal to pivot (lt) element so we just increment i
                   lt    i                            gt
                    |    |                             |
                    v    v                             v
    "A", "B", "C", "P", "W", "P", "P", "V", "P", "D", "P", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high

    now element at i is greater than pivot element so exchange with gt
                   lt    i                       gt
                    |    |                        |
                    v    v                        v
    "A", "B", "C", "P", "P", "P", "P", "V", "P", "D", "W", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high
    now element at i is equal to pivot element so increment i
                   lt         i                  gt
                    |         |                   |
                    v         v                   v
    "A", "B", "C", "P", "P", "P", "P", "V", "P", "D", "W", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high
   now element at i is equal to pivot element so increment i
                   lt              i             gt
                    |              |              |
                    v              v              v
    "A", "B", "C", "P", "P", "P", "P", "V", "P", "D", "W", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high

   now element at i is equal to pivot element so increment i
                   lt                   i        gt
                    |                   |         |
                    v                   v         v
    "A", "B", "C", "P", "P", "P", "P", "V", "P", "D", "W", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high
    now element at i is greater than pivot element so exchange with gt
                   lt                   i    gt
                    |                   |    |
                    v                   v    v
    "A", "B", "C", "P", "P", "P", "P", "D", "P", "V", "W", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high

    now element at i is less than pivot element so exchange with lt
                         lt                 i,gt
                         |                   |
                         v                   v
    "A", "B", "C", "D", "P", "P", "P", "P", "P", "V", "W", "Y", "Z", "X"
     ^                                                                ^
     |                                                                |
    low                                                              high

    now i and gt have crossed so we have sorted the array
 */
public class ThreeWayPartitioning<T extends Comparable<T>> implements Sort<T> {

    private void sort (T[] elements, int low, int high) {
        if (high <= low) {
            return;
        }
        int lt = low;
        int gt = high;

        T pivot = elements[low];
        int i = low;

        while (i <= gt) {
            int cmp = elements[i].compareTo(pivot);
            if (cmp < 0) {
                exch(elements, lt++, i++);
            } else if ( cmp > 0) {
                exch(elements, i, gt--);
            } else {
                i++;
            }
        }

        sort(elements, low, lt - 1);
        sort(elements, gt+1, high);
    }

    private void exch(T[] elements, int i, int i1) {
        T temp = elements[i];
        elements[i] = elements[i1];
        elements[i1] = temp;
    }

    @Override
    public T[] sort(T[] elements) {
        int low = 0;
        int high = elements.length - 1;
        sort(elements, low, high);
        return elements;
    }
}
