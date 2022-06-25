package com.dsa.interview.questions.search_in_rotated_sorted_array;

/*
    Find index of element in a rotated sorted array

            Array           |       Find element        |       Index
    ------------------------|---------------------------|------------------
        [5,6,7,8,9,1,2,3,4] |               3           |       7
        [5,6,7,8,9,1,2,3,4] |              30           |       -1
        [4,5,6,7,0,1,2,3]   |               0           |       4

        Time Complexity : O(N)
        Space Complexity : O(1)

        suppose we have arr = [1, 2, 3, 4, 5]
        rotated sorted arr  = [3, 4, 5, 1, 2]

        Assumption : No duplicates

        Approach 1: Linear Search
                    Time complexity : O(N)
                    Space Complexity : O(1)

        Approach 2: Binary Search

        ^
      5 |    /|
        |   / |
      4 |  /  |
        | /   |
      3 |/    |
        |s    |   e
      2 |     |  /
        |     | /
      1 |     |/
        +-------------------->

            Cases             |               Sub case                |     Action
  ----------------------------|---------------------------------------|-----------------------
 1.   arr[start] <= arr[mid]  | key >= arr[start] && key <= arr[mid]  |   end = mid - 1
 2.                           |                else                   |   start = mid + 1
 3.    arr[mid] <= arr[end]   | key <= arr[end] && key >= arr[mid]    |   start = mid + 1
 4.                           |                else                   |   end = mid - 1

   Example 1 : 3 4 5 1 2

    case 1 :
    Key = 1
    mid = (0 + 4) / 2 = 2

    arr[start] = arr[0] = 3
    arr[mid]   = arr[2] = 5
    arr[end]   = arr[4] = 2

    arr[start] <= arr[mid] => else => case 2
    start = mid + 1 => 2 + 1 => 3

    mid = ( 3 + 4 ) / 2 = 3
    arr[start] = arr[3] = 1
    arr[mid]   = arr[3] = 1
    arr[end]   = arr[4] = 2

    arr[mid] == key = 1
        found key

    case 2 :
    Key = 4
    mid = (0 + 4) / 2 = 2

    arr[start] = arr[0] = 3
    arr[mid]   = arr[2] = 5
    arr[end]   = arr[4] = 2

    arr[start] <= arr[mid] => key >= arr[start] && key <= arr[mid] => case 1
    end = mid - 1 => 2 - 1 => 1

    mid = ( 0 + 1 ) / 2 = 0
    arr[start] = arr[0] = 3
    arr[mid]   = arr[0] = 3
    arr[end]   = arr[1] = 4
    arr[start] <= arr[mid] => else] => case 2
    start = mid + 1 => 0 + 1 => 1

    mid = (1 + 1) / 2 = 1
    arr[start] = arr[1] = 4
    arr[mid] = arr[1] = 4
    arr[end] = arr[1] = 4

    arr[mid] == key = 4
        found key

 */
public class SearchElementInRotatedSortedArray {

    public int find(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            // upper line
            if (arr[start] <= arr[mid]) {
                // case 1, between start and mid
                if (key >= arr[start] && key <= arr[mid]) {
                    end = mid - 1;
                }
                // case 2
                else {
                    start = mid + 1;
                }
            }
            // lower line
            else {
                // case 3, between mid and end
                if (key >= arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                }
                // case 4
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
