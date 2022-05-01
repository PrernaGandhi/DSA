package linear_search;

// time complexity : O(N)
public class LinearSearch {
    public int iterativeSearch(int[] arr, int element) {
        for(int index = 0; index < arr.length; index ++) {
            if(arr[index] == element) return index;
        }
        return -1;
    }

    public int recursiveSearch(int[] arr, int element, int index) {
        if(index == arr.length) return -1;
        if(arr[index] == element) return index;
        return recursiveSearch(arr, element, index + 1);

    }
}
