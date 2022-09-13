package com.dsa.coursera_algo_part_1.sorts.merge_sort.bottom_up;

public class MergeSort<T extends Comparable<T>> extends
    com.dsa.coursera_algo_part_1.sorts.merge_sort.recursive.MergeSort<T> {

    @Override
    public T[] sort(T[] elements) {
        int N = elements.length;
        T[] copy = (T[]) new Comparable[N];
        // It will move like 1, 2, 4, 8, 16
        // first we will take array of size 1, then 2, then 4, then 8
        for (int sz = 1; sz < N; sz = sz + sz) {
            // now low will start from 0, and till N - sz
            // so if we are sorting array of size 2
            // then last low element would be N-2
            // now to increment,
            // for arrays of size 1, we will merge first two,
            // hence whatever the size maybe we will merge elements
            // equal to double the size of arrays we are considering
            // from the current low
            // hence low = low + size + size
            for (int low = 0; low < N - sz; low += sz + sz) {
                // now we already know the low
                // for the highest element
                // it could either be the last element,
                // or low + size + size + 1
                // which means for the current low,
                // the next low element + 1 would be the high
                // for the current low

                // Now for mid
                // current low plus size of the array we are considering - 1
                merge(elements, copy, low, low + sz - 1, Math.min(low + sz + sz + 1, N - 1));
            }
        }
        return super.sort(elements);
    }
}
