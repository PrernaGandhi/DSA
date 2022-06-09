package com.dsa.dp.bin_packing_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    We have several items, we need to fit all these items in minimum number of bin
    Note: we cannot break the item to fit a given item into two pieces
    All bins have the same fixed capacity.

    First Fit Decreasing Problem :
    We sort the items in descending order,
    and then try to fit each of the items
    on a one by one basis.

    If the first item after the items are sorted in descending order
    does not fit into the bin, then there is no possible solution for this problem

    Bin Capacity : 5
    Items : 2, 4, 3, 2, 1

    Step 1: Sort items in descending order
    Items : 4, 3, 2, 2, 1,

    create the first bin and fit the first item into it

    |     |
    |_____|
    |     |
    |  4  |
    |     |
    |_____|

    now let's try to fit 2nd item in 1st bin, not possible
    so we create a new bin

    |     |         |     |
    |_____|         |     |
    |     |         |_____|
    |  4  |         |     |
    |     |         |  3  |
    |_____|         |_____|

    now let's try to fit the 3rd item in the 1st bin, not possible
    let's try to put the third item in the 2nd bin


    |     |         |_____|
    |_____|         |  2  |
    |     |         |_____|
    |  4  |         |     |
    |     |         |  3  |
    |_____|         |_____|

    Bin 2 is full
    now let's try to fit the 4th item in the 1st bin

    |     |         |_____|         |     |
    |_____|         |  2  |         |     |
    |     |         |_____|         |     |
    |  4  |         |     |         |_____|
    |     |         |  3  |         |  2  |
    |_____|         |_____|         |_____|

    Bin 2 is full
    now let's try to fit item 5 in bin 1, not possible
    let's try to fit the item 5 in bin 2, not possible since bin 2 is full
    we create a new bin to add the 3rd item

    |_____|         |_____|         |     |
    |__1__|         |  2  |         |     |
    |     |         |_____|         |     |
    |  4  |         |     |         |_____|
    |     |         |  3  |         |  2  |
    |_____|         |_____|         |_____|


 */
public class FirstFitDecreasingProblem {

    private List<Bin> bins;
    private List<Integer> items;
    private int binCapacity;
    private int binCounter = 1;

    public FirstFitDecreasingProblem(List<Integer> items, int binCapacity) {
        this.binCapacity = binCapacity;
        this.items = items;
        this.bins = new ArrayList<>(this.items.size());
    }

    public void solve() {
        // sort items in reverse order
        Collections.sort(items, Collections.reverseOrder());

        // there is no feasible solution is the largest item doesn't fit in the bin
        if (items.get(0) > binCapacity) {
            System.out.println("There is no feasible solution .... ");
            return;
        }

        // create a new first bin
        bins.add(new Bin(binCounter, binCapacity));

        // iterate through items that are in descending order
        for (Integer item : items) {
            boolean isItemInsertedInTheBin = false;
            int currentBinIndex = 0;
            while (!isItemInsertedInTheBin) {
                // when we have checked all the bin available,
                // but the item doesn't fit
                if (currentBinIndex == bins.size()) {
                    // so we create a new bin to fit this item
                    Bin newBin = new Bin(++binCounter, binCapacity);
                    newBin.put(item);
                    bins.add(newBin);
                    isItemInsertedInTheBin = true;
                    // try to check if the item can fit in the existing bin
                } else if (bins.get(currentBinIndex).put(item)) {
                    // this is when item actually fits in the bin
                    isItemInsertedInTheBin = true;
                } else {
                    // try next bin if the item doesn't fit in the current bin
                    currentBinIndex++;
                }
            }
        }
    }

    public void showResults() {
        for (Bin bin : this.bins) {
            System.out.println(bin);
        }
    }
}
