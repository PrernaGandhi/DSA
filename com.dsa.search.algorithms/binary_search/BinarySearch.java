package binary_search;

// time complexity - O(log N)
public class BinarySearch {
    public int iterativeSearch(int[] arr, int element) {
        int middle = arr.length / 2;
        int end = arr.length;
        int start = 0;
        while(start < end) {
            if(element == arr[middle]) return middle;
            if(element < arr[middle]) {
                end = middle;
                middle = (start + end) / 2;
            } else if (element > arr[middle]){
                start = middle + 1;
                middle = (start + end) / 2;
            }
        }
        return -1;
    }

    public int recursiveHeadSearch(int[] arr, int element, int start, int middle, int end) {
        if(start >= end) return -1;
        if(arr[middle] == element)
            return middle;
        if(element < arr[middle])
            return recursiveHeadSearch(arr, element, start,(start + middle) / 2 ,middle);
        else
            return recursiveHeadSearch(arr, element, middle + 1,(middle + 1 + end) / 2 ,end);
    }

    public int recursiveTailSearch(int[] arr, int element, int start, int middle, int end) {
        if(start >= end) return -1;
        if(arr[middle] == element) return middle;
        if(element < arr[middle])
            end = middle;
         else
            start = middle + 1;

        middle = (start + end) / 2;
        return recursiveTailSearch(arr, element, start,middle ,end);
    }
}
