package medians_of_medians;

import quick_select.QuickSelect;

public class MediansOfMedians extends QuickSelect {
    // the only difference between Medians Of Medians Algo and QuickSelect is the way to choose pivot
    // time complexity : O(N)
    // we first divide the array in chunks of 5, sort each chunk, take median of each chunk,
    // then take median of all medians
    // 1 -2 5 8 7 6 10 4 18 2 3 -4 55 0 11
    // 1 -2 5 8 7       6 10 4 18 2         3 -4 55 0 11
    // -2 1 5 8 7       2 4 6 10 18         -4 0 3 11 55
    //      5               6                    3
    //              3   5   6
    //                  5
    // 1 -2 4 2 3 -4 0      5       18 8 7 6 55 10 11

    int[] med;
    int index = 0;

    MediansOfMedians(int[] arr) {
        super(arr);
        this.med = new int[(arr.length % 5 == 0 ? arr.length / 5 : arr.length + 1)];
    }

    @Override
    public int getPivot(int fIndex, int lIndex) {
        for (int i = fIndex; i <= lIndex; i += 5) {

            int min = Math.min(i + 5, lIndex);
            // sort arrays in chunks of 5
            sort(arr, i, min);
            // find the median in the array
            med[index] = (int) Math.round((min + i) / 2.0);
            index++;
        }
        // this contains index of medians of each chunk of array
        sort(med, 0, index);
        // find the medianIndex
        int medianIndex = (index - 1) / 2;
        // median of median
        int median = med[medianIndex];
        this.med = new int[(arr.length / 5) + 1];
        index = 0;
        return median;
    }

    // sort using insertion sort
    private void sort(int[] arr, int start, int end) {
        for (int i = start; i < end; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
