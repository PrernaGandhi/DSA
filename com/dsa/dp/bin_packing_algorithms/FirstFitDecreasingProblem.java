package com.dsa.dp.bin_packing_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        // sort collection in reverse order
        Collections.sort(items, Collections.reverseOrder());

        // there is no feasible solution
        if(items.get(0) > binCapacity) {
            System.out.println("There is no feasible solution .... ");
            return;
        }

        // first bin
        bins.add(new Bin(binCounter, binCapacity));

        for(Integer item : items) {
            boolean isOk = false;
            int currentBinIndex = 0;
            while(!isOk) {
                if(currentBinIndex == bins.size()) {
                    Bin newBin = new Bin(++binCounter,binCapacity);
                    newBin.put(item);
                    bins.add(newBin);
                    isOk = true;
                } else if(bins.get(currentBinIndex).put(item)) { // this is when item actually fits in the bin
                    isOk = true;
                } else {
                    // try next bin
                    currentBinIndex ++;
                }
            }
        }
    }
    public void showResults() {
        for(Bin bin : this.bins) {
            System.out.println(bin);
        }
    }
}
