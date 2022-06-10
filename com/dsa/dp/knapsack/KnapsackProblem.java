package com.dsa.dp.knapsack;

/*
    Knapsack Problem :
        There are no of items N with w(i) weight, and a knapsack capacity of C.

        There are two things that can happen,
            1. either we take the given item, or,
            2. not take the given item

        We will try to break the problem into sub problems
        and construct a dp table to help us find the result of a bigger problem

        Let there be 4 items with the following weights and values:
        weights = [0, 1, 3, 4, 5]
        values = [0, 1, 4, 5, 7]

        let capacity of knapsack be 7

        Our goal is to maximize the value.

                                      <----------- capacity of knapsack ----------->
                            |   0       1       2       3       4       5       6       7
    ^    -------------------|-----------------------------------------------------------------
    |    No items taken     |   0       0       0       0       0       0       0       0
 items   1st                |   0       1       1       1       1       1       1       1
 taken   2nd                |   0       1       1       4       5       5       5       5
    |    3rd                |   0       1       1       4       5       6       6       9
    v    4th                |   0       1       1       4       5       7       8       9
                            |

    So having 4 elements with capacity of knapsack as 7,
    maximum profit we can make is $9

    Now let's try to formulate how this table is constructed

    For cases where capacity is 0 or where we are considering 0 items,
    we will have all zeroes

        weights = [0, 1, 3, 4, 5]
        values = [0, 1, 4, 5, 7]

        Item    |   Capacity    |   Taking Item (w[i] < Capacity)  |     Not Taking Item   |     Max     Profit
    ------------|---------------|----------------------------------|-----------------------|---------------------
        I0      |       0       |           0                      |           0           |            0
        I1      |       0       |           0                      |      F(1-1,0) = 0     |            0
        I2      |       0       |           0                      |      F(2-1,0) = 0     |            0
        I3      |       0       |           0                      |      F(3-1,0) = 0     |            0
        I4      |       0       |           0                      |      F(4-1,0) = 0     |            0


        Item    |   Capacity    |   Taking Item (w[i] < Capacity)  |     Not Taking Item   |     Max     Profit
    ------------|---------------|----------------------------------|-----------------------|---------------------
        I0      |       1       |           0                      |           0           |            0
        I1      |       1       | V[1] + F(1-1, 1-1) = 1 + 0 = 1   |      F(1-1,1) = 0     |            1
        I2      |       1       |       can't fit item             |      F(2-1,1) = 1     |            1
        I3      |       1       |       can't fit item             |      F(3-1,1) = 1     |            1
        I4      |       1       |       can't fit item             |      F(4-1,1) = 1     |            1


        Item    |   Capacity    |   Taking Item (w[i] < Capacity)  |     Not Taking Item   |     Max     Profit
    ------------|---------------|----------------------------------|-----------------------|---------------------
        I0      |       2       |           0                      |           0           |            0
        I1      |       2       | V[1] + F(1-1, 2-1) = 1 + 0 = 1   |      F(1-1,2) = 0     |            1
        I2      |       2       |       can't fit item             |      F(2-1,2) = 1     |            1
        I3      |       2       |       can't fit item             |      F(3-1,2) = 1     |            1
        I4      |       2       |       can't fit item             |      F(4-1,2) = 1     |            1


        Item    |   Capacity    |   Taking Item (w[i] < Capacity)  |     Not Taking Item   |     Max     Profit
    ------------|---------------|----------------------------------|-----------------------|---------------------
        I0      |       3       |           0                      |           0           |            0
        I1      |       3       | V[1] + F(1-1, 3-1) = 1 + 0 = 1   |      F(1-1,3) = 0     |            1
        I2      |       3       | V[2] + F(2-1, 3-3) = 4 + 0 = 4   |      F(2-1,3) = 1     |            4
        I3      |       3       |       can't fit item             |      F(3-1,3) = 4     |            4
        I4      |       3       |       can't fit item             |      F(4-1,3) = 4     |            4


        Item    |   Capacity    |   Taking Item (w[i] < Capacity)  |     Not Taking Item   |     Max     Profit
    ------------|---------------|----------------------------------|-----------------------|---------------------
        I0      |       4       |           0                      |           0           |            0
        I1      |       4       | V[1] + F(1-1, 4-1) = 1 + 0 = 1   |      F(1-1,4) = 0     |            1
        I2      |       4       | V[2] + F(2-1, 4-3) = 4 + 1 = 5   |      F(2-1,4) = 1     |            5
        I3      |       4       | V[3] + F(3-1, 4-4) = 5 + 0 = 5   |      F(3-1,4) = 5     |            5
        I4      |       4       |       can't fit item             |      F(4-1,4) = 5     |            5


        Item    |   Capacity    |   Taking Item (w[i] < Capacity)  |     Not Taking Item   |     Max     Profit
    ------------|---------------|----------------------------------|-----------------------|---------------------
        I0      |       5       |           0                      |           0           |            0
        I1      |       5       | V[1] + F(1-1, 5-1) = 1 + 0 = 1   |      F(1-1,5) = 0     |            1
        I2      |       5       | V[2] + F(2-1, 5-3) = 4 + 1 = 5   |      F(2-1,5) = 1     |            5
        I3      |       5       | V[3] + F(3-1, 5-4) = 5 + 1 = 6   |      F(3-1,5) = 5     |            6
        I4      |       5       | V[4] + F(4-1, 5-5) = 7 + 0 = 7   |      F(4-1,5) = 6     |            7


        Item    |   Capacity    |   Taking Item (w[i] < Capacity)  |     Not Taking Item   |     Max     Profit
    ------------|---------------|----------------------------------|-----------------------|---------------------
        I0      |       7       |           0                      |           0           |            0
        I1      |       7       | V[1] + F(1-1, 7-1) = 1 + 0 = 1   |      F(1-1,7) = 0     |            1
        I2      |       7       | V[2] + F(2-1, 7-3) = 4 + 1 = 5   |      F(2-1,7) = 1     |            5
        I3      |       7       | V[3] + F(3-1, 7-4) = 5 + 4 = 9   |      F(3-1,7) = 5     |            9
        I4      |       7       | V[4] + F(4-1, 7-5) = 7 + 1 = 8   |      F(4-1,7) = 9     |            9

    So maximum profit for a knapsack of capacity 7 with 4 items of
    weights = [0, 1, 3, 4, 5]
    values = [0, 1, 4, 5, 7]
    is $9
 */
public class KnapsackProblem {
    // total number of items
    private int noOfItems;

    // total capacity of Knapsack
    private int capacityOfKnapsack;

    // dynamic programming table (2d array)
    private int[][] dpTable;

    private int[] weights;

    private int[] values;

    public KnapsackProblem(int noOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
        this.noOfItems = noOfItems;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.weights = weights;
        this.values = values;
        this.dpTable = new int[noOfItems + 1][capacityOfKnapsack + 1];
    }

    public void solve() {

        // time complexity O(noOfItems * capacityOfKnapsack)
        // iterating over each item on a one by one basis
        for (int givenItemIndex = 1; givenItemIndex < noOfItems + 1; givenItemIndex++) {
            // iterating over thw capacity of knapsack from 0 to actual knapsack capacity
            for (int currentKnapsackCapacity = 1; currentKnapsackCapacity < capacityOfKnapsack + 1; currentKnapsackCapacity++) {
                // if we are not taking the item,
                // it means we are taking the previous state
                // as the best state, it would be stored one
                // givenItemIndex above where we are not taking this item
                int notTakingItem = dpTable[givenItemIndex - 1][currentKnapsackCapacity];
                int takingItem = 0;

                // check if item can be taken
                // if the weight of the given item is
                // less than or equal to the capacity of the knapsack
                if (weights[givenItemIndex] <= currentKnapsackCapacity) {
                    // add the value of the given item
                    // since we are taking this item,
                    // we can find the result for this problem by finding the result of
                    // capacity of knapsack - weight of item we are considering at the moment
                    takingItem = values[givenItemIndex] + dpTable[givenItemIndex - 1][currentKnapsackCapacity - weights[givenItemIndex]];
                }
                // memoization, we store the result
                // we take the max value
                // so we take into account whether taking the given item
                // is beneficial or not
                dpTable[givenItemIndex][currentKnapsackCapacity] = Math.max(notTakingItem, takingItem);
            }
        }
    }

    public void showResult() {
        System.out.println("Total benefit : $" + dpTable[noOfItems][capacityOfKnapsack]);
        for (int givenItemIndex = noOfItems, currentKnapsackCapacity = capacityOfKnapsack;
             givenItemIndex > 0; givenItemIndex--) {
            // if value in the dp table is 0, we have reached the end
            if (dpTable[givenItemIndex][currentKnapsackCapacity] != 0 &&
                    // if the value in dp table and the value in the
                    // above row and same column is same, it means
                    // we haven't taken the item
                    dpTable[givenItemIndex][currentKnapsackCapacity] != dpTable[givenItemIndex - 1][currentKnapsackCapacity]) {
                System.out.println("We take item #" + givenItemIndex);
                // if we take the item we need to reduce the current knapsack capacity
                // with the weight of the item that we have chosen to take
                currentKnapsackCapacity = currentKnapsackCapacity - weights[givenItemIndex];
            }
        }
    }

    public int solveUsingRecursion(int capacityOfKnapsack, int noOfItems) {
        // base case, if capacity of knapsack is 0,
        // or we have 0 items, the profit would be $0
        if (capacityOfKnapsack == 0 || noOfItems == 0)
            return 0;

        int profitAfterIncludingTheItem = 0;
        int profitAfterExcludingTheItem = 0;
        // the given item can NOT fit into the knapsack
        // if the weight of the current item is greater
        // than size of knapsack
        if (weights[noOfItems] > capacityOfKnapsack) {
            profitAfterExcludingTheItem = solveUsingRecursion(capacityOfKnapsack, noOfItems - 1);
        }
        // we include the item if it fits into the knapsack
        else {
            // if we include the item we add the value of the item into our profit
            profitAfterIncludingTheItem = values[noOfItems] +
                    // if we include the item capacity of knapsack decreases by weight of the given item
                    solveUsingRecursion(capacityOfKnapsack - weights[noOfItems],
                            noOfItems);
        }
        return Math.max(profitAfterIncludingTheItem, profitAfterExcludingTheItem);
    }

}