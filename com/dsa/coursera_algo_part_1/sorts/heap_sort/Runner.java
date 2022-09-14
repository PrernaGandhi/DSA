package com.dsa.coursera_algo_part_1.sorts.heap_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        Sort<Integer> sort = new HeapSort<>();
        Integer[] elements = {7, 10, 5, 3, 8, 4, 2, 9, 6};

        // 2    3   4	5	6	7	8	9	10
        elements = sort.sort(elements);
        Arrays.stream(elements).forEach(e -> System.out.print(e + "\t"));

        System.out.println();

        Sort<String> sortStrings = new HeapSort<>();
        String[] strings = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

        // A	E	E	L	M	O	P	R	S	T	X
        strings = sortStrings.sort(strings);
        Arrays.stream(strings).forEach(e -> System.out.print(e + "\t"));

        System.out.println();
        Sort<String> sortDuplicateStrings = new HeapSort<>();
        String[] duplicateStrings = {"P", "A", "B", "X", "W", "P", "P", "V", "P", "D", "P", "C", "Y", "Z"};

        // A	B	C	D	P	P	P	P	P	V	W	X	Y	Z
        duplicateStrings = sortDuplicateStrings.sort(duplicateStrings);
        Arrays.stream(duplicateStrings).forEach(e -> System.out.print(e + "\t"));


    }

}
