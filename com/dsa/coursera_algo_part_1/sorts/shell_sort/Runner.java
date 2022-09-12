package com.dsa.coursera_algo_part_1.sorts.shell_sort;

import com.dsa.coursera_algo_part_1.sorts.Sort;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        Sort<Integer> sort = new ShellSort<>();
        Integer[] elements = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        elements = sort.sort(elements);
        Arrays.stream(elements).forEach(e -> System.out.print(e + "\t"));

        System.out.println();

        Sort<String> sortStrings = new ShellSort<>();
        String[] strings = {"S","O","R","T","E","X","A","M","P","L","E"};
        strings = sortStrings.sort(strings);
        Arrays.stream(strings).forEach(e -> System.out.print(e + "\t"));


    }

}
