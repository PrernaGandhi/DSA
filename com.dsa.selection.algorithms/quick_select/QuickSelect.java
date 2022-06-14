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

    /*
        Let's see an example
        2 -1 5 8 7 9 6 1

        Value of k is 3 - 1

      Step          |   i   |   arr[i] < arr[lastIndex]     |   firstIndex  |   lastIndex   |   pivotIndex  |       Current array
  ------------------|-------|-------------------------------|---------------|---------------|---------------|-------------------------
partition(0,7)      |       |                               |       0       |       7       |       3       |   [2, -1, 5, 8, 7, 9, 6, 1]
    swap(3,7)       |       |                               |       0       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
    sort            |   0   |           true                |       0       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
swap(firstIndex,i)  |   0   |                               |       0       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
firstIndex++        |   0   |                               |       1       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
    sort            |   1   |           true                |       1       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
swap(firstIndex,i)  |   1   |                               |       1       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
firstIndex++        |   1   |                               |       2       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
    sort            |   2   |           true                |       2       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
swap(firstIndex,i)  |   2   |                               |       2       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
firstIndex++        |   2   |                               |       3       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
    sort            |   3   |           true                |       3       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
swap(firstIndex,i)  |   3   |                               |       3       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
firstIndex++        |   3   |                               |       4       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
    sort            |   4   |           true                |       4       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
swap(firstIndex,i)  |   4   |                               |       4       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
firstIndex++        |   4   |                               |       5       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
    sort            |   5   |           false               |       5       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
    sort            |   6   |           true                |       5       |       7       |       3       |   [2, -1, 5, 1, 7, 9, 6, 8]
swap(firstIndex,i)  |   6   |                               |       5       |       7       |       3       |   [2, -1, 5, 1, 7, 6, 9, 8]
firstIndex++        |   6   |                               |       6       |       7       |       3       |   [2, -1, 5, 1, 7, 6, 9, 8]
swap(lastIndex,     |       |                               |               |               |               |   [2, -1, 5, 1, 7, 6, 8, 9]
       firstIndex)  |       |                               |               |               |               |
                firstIndex = 6 is returned as the pivot index
--------------------|-------|-------------------------------|---------------|---------------|---------------|-------------------------------
     pivotIndex = 6 > k = 2
     firstIndex = 0, lastIndex = pivotIndex - 1 = 6 - 1 = 5
   partition(0,5)   |       |                               |       0       |       5       |       3       |   [2, -1, 5, 1, 7, 6 | 8, 9]
    swap(3,5)       |       |                               |       0       |       5       |       3       |   [2, -1, 5, 6, 7, 1 | 8, 9]
    sort            |   0   |               false           |       0       |       5       |       3       |   [2, -1, 5, 6, 7, 1 | 8, 9]
    sort            |   1   |               true            |       0       |       5       |       3       |   [2, -1, 5, 6, 7, 1 | 8, 9]
swap(firstIndex,i)  |   1   |                               |       0       |       5       |       3       |   [-1, 2, 5, 6, 7, 1 | 9, 8]
firstIndex++        |   1   |                               |       1       |       5       |       3       |   [-1, 2, 5, 6, 7, 1 | 9, 8]
    sort            |   2   |               false           |       1       |       5       |       3       |   [-1, 2, 5, 6, 7, 1 | 9, 8]
    sort            |   3   |               false           |       1       |       5       |       3       |   [-1, 2, 5, 6, 7, 1 | 9, 8]
    sort            |   4   |               false           |       1       |       5       |       3       |   [-1, 2, 5, 6, 7, 1 | 9, 8]
swap(lastIndex,     |       |                               |               |               |               |   [-1, 1, 5, 6, 7, 2 | 9, 8]
        firstIndex) |       |                               |               |               |               |
        firstIndex = 1 is returned as the pivot index
--------------------|-------|-------------------------------|---------------|---------------|---------------|-------------------------------
    pivotIndex = 1 < k = 2
    firstIndex = pivotIndex + 1 = 2, lastIndex = 5
   partition(2,5)   |       |                               |       2       |       5       |       3       |   [-1, 1 | 5, 6, 7, 2 | 9, 8]
    swap(3,5)       |       |                               |       2       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
    sort            |   2   |               true            |       2       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
swap(firstIndex, i) |   2   |                               |       2       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
firstIndex++        |   2   |                               |       3       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
    sort            |   3   |               true            |       3       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
swap(firstIndex,i)  |   3   |                               |       3       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
firstIndex++        |   3   |                               |       4       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
    sort            |   4   |              false            |       4       |       5       |       3       |   [-1, 1 | 5, 2, 7, 6 | 9, 8]
swap(lastIndex,     |       |                               |               |               |               |   [-1, 1 | 5, 2, 6, 7 | 9, 8]
        firstIndex) |       |                               |               |               |               |
        firstIndex = 4 is returned as the pivot index
--------------------|-------|-------------------------------|---------------|---------------|---------------|--------------------------------
    pivotIndex = 4 > k = 2
    firstIndex = 2, lastIndex = pivotIndex - 1 = 4 - 1 = 3
   partition(2,3)   |       |                               |       2       |       3       |       3       |   [-1, 1 | 5, 2 | 6, 7, 9, 8]
   swap(3,3)        |       |                               |       2       |       3       |       3       |   [-1, 1 | 5, 2 | 6, 7, 9, 8]
   sort             |   2   |           false               |       2       |       3       |       3       |   [-1, 1 | 5, 2 | 6, 7, 9, 8]
swap(lastIndex,     |       |                               |               |               |               |   [-1, 1 | 2, 3 | 6, 7, 9, 8]
        firstIndex) |       |                               |               |               |               |
        firstIndex = 2 is returned as the pivot index

Since pivotIndex = 2 == k
So Result : 2 is the 3rd smallest element in the array
     */

    public int[] arr;

    public QuickSelect(int[] arr) {
        this.arr = arr;
    }

    public int quickSelect(int k) {
        // since indices start with 0,
        // if we want to find the 1st smallest element in
        // an array of 5 elements, then we would be looking
        // for 0th index in an array sorted in ascending order
        return select(0, arr.length - 1, k - 1);
    }

    public int select(int firstIndex, int lastIndex, int k) {
        int pivotIndex = partition(firstIndex, lastIndex);
        if (pivotIndex < k) {
            return select(pivotIndex + 1, lastIndex, k);
        } else if (pivotIndex > k) {
            return select(firstIndex, pivotIndex - 1, k);
        }

        return arr[pivotIndex];
    }

    private int partition(int firstIndex, int lastIndex) {
        // generate a random pivotIndex
        int pivotIndex = getPivot(firstIndex, lastIndex);
        swap(pivotIndex, lastIndex);
        for (int i = firstIndex; i < lastIndex; i++) {
            if (arr[i] < arr[lastIndex]) {
                swap(i, firstIndex);
                firstIndex++;
            }
        }
        // swap the first and last index
        // first index will point to the element greater than the pivot element
        // so we swap it
        swap(lastIndex, firstIndex);
        return firstIndex;
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
