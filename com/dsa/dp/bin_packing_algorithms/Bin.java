package com.dsa.dp.bin_packing_algorithms;

import java.util.ArrayList;
import java.util.List;

public class Bin {

    // each bin will have a unique id
    private int id;
    // capacity of the bin
    private int capacity;
    // actual no of units filled in the bin
    private int actualSize;

    private List<Integer> items;

    public Bin(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public boolean put(Integer item) {
        // item doesn't fit in the bin
        if (actualSize + item > capacity) {
            return false;
        }

        // add item to bin
        items.add(item);
        // increment the size of the bin by the item size
        actualSize += item;
        return true;
    }


    @Override
    public String toString() {
        String contentOfBin = "Items in bin : #" + this.id + " : ";
        for (Integer item : this.items) {
            contentOfBin += item + " ";
        }
        return contentOfBin;
    }
}
