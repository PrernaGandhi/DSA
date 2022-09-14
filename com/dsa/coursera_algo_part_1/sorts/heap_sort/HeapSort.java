package com.dsa.coursera_algo_part_1.sorts.heap_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;

/*
    Heap sort uses max heap under the hood
    Build max heap using bottom-up method
    sort down - delete the largest remaining item

    Nlog N in place sorting algorithm, but not stable
    poor use of cache memory
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public T[] sort(T[] elements) {
        buildMaxHeap(elements);
        sortDown(elements, elements.length - 1);
        return elements;
    }

    private void sortDown(T[] elements, int length) {
        while (length >= 0) {
            exchange(elements, 0, length);
            sink(elements, 0, --length);
        }
    }

    private void buildMaxHeap(T[] elements) {
        for (int parentIndex = elements.length / 2; parentIndex >= 0; parentIndex--) {
            sink(elements, parentIndex, elements.length - 1);
        }
    }

    private void sink(T[] elements, int parentIndex, int length) {
        // this takes longer, and hence not used much
        while (parentIndex * 2 <= length) {
            // this should be inside the loop
            int childIndex = parentIndex * 2;
            if (childIndex < length && less(elements[childIndex], elements[childIndex + 1])) {
                childIndex++;
            }
            if (!less(elements[parentIndex], elements[childIndex])) {
                break;
            }
            exchange(elements, parentIndex, childIndex);
            parentIndex = childIndex;
        }
    }
}
