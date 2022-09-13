package com.dsa.coursera_algo_part_1.shuffling;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Integer[] elements = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        Shuffling<Integer> shuffling = new Shuffling<>();
        Arrays.stream(elements).forEach(e ->System.out.print(e + " "));
        shuffling.shuffle(elements);
        System.out.println();
        Arrays.stream(elements).forEach(e ->System.out.print(e + " "));
    }

}
