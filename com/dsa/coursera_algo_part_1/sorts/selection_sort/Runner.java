package com.dsa.coursera_algo_part_1.sorts.selection_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        Sort<Integer> sort = new SelectionSort<>();
        Integer[] elements = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        elements = sort.sort(elements);
        Arrays.stream(elements).forEach(e -> System.out.print(e + "\t"));
    }

}
