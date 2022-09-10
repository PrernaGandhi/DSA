package com.dsa.coursera_algo_part_1.sorts;


public interface Sort<T extends Comparable<T>> {

    T[] sort(T[] elements);

    default boolean less(T elementOne, T elementTwo) {
        return elementOne.compareTo(elementTwo) < 0;
    }

    default void exchange(T[] elements, int indexOne, int indexTwo) {
        T temp = elements[indexOne];
        elements[indexOne] = elements[indexTwo];
        elements[indexTwo] = temp;
    }

}
