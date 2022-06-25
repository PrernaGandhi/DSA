package com.dsa.interview.questions.moore_voting;

/*
    We need to find the majority element in the array
    A majority element is the one that appears more
    than N/2 times in an array

    Examples:

        Array               |   N/2 value   |       Majority element
 ---------------------------|---------------|---------------------------
    [3,2,3]                 |       1       |               3
    [2,2,1,1,1,2,2]         |       3       |               2
    [4,7,4,4,7,4,4,9,4,3]   |       5       |               4
    [2,1,2,4,7]             |       2       |       no majority element

    Assumption : we will always have a majority element
    We can only have one majority element

    Approach 1: Bruteforce approach
    Iterate over the array, check frequency of
                each element one by one,
                if frequency > N/2, return
                Time complexity: O(N^2)
                Space complexity: O(1)

    Approach 2: Hashing
    Store frequency of each element in hash map
                Time complexity : O(N)
                Space complexity : O(N)

    Approach 3: Sorting
    Sort the array and find the mid element
                Time complexity: O(NlogN)
                Space complexity: O(1)

    Approach 4: Moore's Voting Approach
    Assume first element as the majority element
    if same element is encountered, count++
    if different element is encountered, count--
    if value of count == 0,
    update the majority element with current element,
    and count = 1

    Example:
    [4, 7, 4, 4, 7, 4, 4, 9, 4, 3]

    i = 0
    element = 4
    majority element = 4
    count = 1

    i = 1
    element = 7
    majority element = 4
    count = 0
    since count becomes 0,
    we update
    majority element = 7
    and count = 1

    i = 2
    element = 4
    majority element = 7
    count = 0
    since count becomes 0,
    we update
    majority element = 4
    and count = 1

    i = 3
    element = 4
    majority element = 4
    increase count
    count = 2

    i = 4
    element = 7
    majority element = 4
    decrease count
    count = 1

    i = 5
    element = 4
    majority element = 4
    increase count
    count = 3

    i = 6
    element = 4
    majority element = 4
    increase count
    count = 4

    i = 7
    element = 9
    majority element = 4
    decrease count
    count = 3

    i = 8
    element = 4
    majority element = 4
    increase count
    count = 4

    i = 9
    element = 3
    majority element = 4
    decrease count
    count = 3

    so majority element = 4
    Time complexity = O(N)
    Space complexity = O(1)

 */
public class MooreVoting {

    public int find(int[] arr) {
        int majorityElement = arr[0];
        int count = 1;
        for (int currentElement : arr) {
            if (currentElement == majorityElement) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majorityElement = currentElement;
                    count = 1;
                }
            }
        }
        return majorityElement;
    }
}
