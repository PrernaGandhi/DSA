package com.dsa.coursera_algo_part_1.shuffling;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/*
    We are shuffling the deck of cards, but generating a random number and swapping the cards at
    current index and random index.
    Note random number is generated between 0 th index and the current index (both inclusive)

    Complexity : O(N)
 */
public class Shuffling<T extends Comparable<T>> {

    private Random random;

    {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void shuffle(T[] array){
        for (int i = 0; i < array.length; i++) {
            int num = random.nextInt(i+1);
            T temp = array[i];
            array[i] = array[num];
            array[num] = temp;
        }
    }

}
