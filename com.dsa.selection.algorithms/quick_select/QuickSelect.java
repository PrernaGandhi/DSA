package quick_select;

import java.util.Random;

public class QuickSelect {
    // An algorithm to find the k th largest/smallest number
    //
    // best case complexity : O(N)
    // worst case complexity : O(N^2)
    //
    // Partition phase takes O(N) time complexity,
    // each time N becomes smaller and smaller,
    // if we are not able to discard many items,
    // then the complexity will be O(N^2) in worst case
    //
    // find pivot -- random -- start and end
    // make sure that elements towards the left are smaller than the pivot
    // and elements towards the right are greater than the pivot element
    // it will be unsorted
    // 2 -1 5 8 7 6
    //      ^
    //      |
    //    pivot
    // to the left are smaller than the pivot, to the right are greater than the pivot
    //
    // 2 -1 5 8 7 9 6 1
    // find the 3rd smallest number -- > 2
    //
    // 2 -1 5 8 7 9 6 1
    // ^      ^       ^
    // |      |       |
    //fIndex  pivot  lIndex
    // 2 -1 5 1 7 9 6 8 (swap with last element)
    // ^              ^
    // |              |
    // |              |
    //fIndex,i       pivot, lIndex
    // 2 -1 5 1 7 9 6 8
    //            ^
    //            |
    //          fIndex, i
    // 2 -1 5 1 7 9 6 8
    //            ^ ^
    //            | |
    //            | |
    //            | i
    //         fIndex
    // 2 -1 5 1 7 6 9 8 (swap element at i and index, if arr[i] < arr[pivot])
    //              ^ ^
    //              | |
    //              | i, lIndex
    //           fIndex
    // 2 -1 5 1 7 6 8 9 (swap fIndex and lIndex)
    
    public int[] arr;
    public QuickSelect(int[] arr) {
        this.arr = arr;
    }

    public int quickSelect(int k) {
        return select(0, arr.length - 1, k - 1);
    }
    public int select(int fIndex, int lIndex, int k) {
        int pivotIndex = partition(fIndex, lIndex);
        if(pivotIndex < k) {
            return select(pivotIndex + 1, lIndex, k);
        } else if (pivotIndex > k) {
            return select(fIndex, pivotIndex - 1, k);
        }

        return arr[pivotIndex];
    }

    private int partition(int fIndex, int lIndex) {
        int pivot = getPivot(fIndex, lIndex);
        swap(pivot, lIndex);
        for(int i = fIndex; i < lIndex; i++) {
            if(arr[i] < arr[lIndex]) {
                swap(i, fIndex);
                fIndex++;
            }
        }
        swap(lIndex, fIndex);
        return fIndex;
    }

    public int getPivot(int fIndex, int lIndex) {
        return new Random().nextInt(lIndex - fIndex + 1) + fIndex;
    }

    public void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
