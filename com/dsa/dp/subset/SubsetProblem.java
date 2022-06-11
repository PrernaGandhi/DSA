package com.dsa.dp.subset;

/*
    we need to find out whether there is a subset that equals to given sums

    Sum = 10

        |   0   |   1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   9   |   10
  ------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|----------
    0   |   1   |   0   |   0   |   0   |   0   |   0   |   0   |   0   |   0   |   0   |   0
    3   |   1   |   0   |   0   |   1   |   0   |   0   |   0   |   0   |   0   |   0   |   0
    4   |   1   |   0   |   0   |   1   |   1   |   0   |   0   |   1   |   0   |   0   |   0
    7   |   1   |   0   |   0   |   1   |   1   |   0   |   0   |   1   |   0   |   0   |   1


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     0     |            1              |               0               |          1
      3     |     1     |     0     |      can't take item      |         F(1-1,0) = 1          |          1
      4     |     2     |     0     |      can't take item      |         F(2-1,0) = 1          |          1
      7     |     3     |     0     |      can't take item      |         F(3-1,0) = 1          |          1


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     1     |            0              |               0               |          0
      3     |     1     |     1     |     can't take item       |         F(1-1,1) = 0          |          0
      4     |     2     |     1     |     can't take item       |         F(2-1,1) = 0          |          0
      7     |     3     |     1     |     can't take item       |         F(3-1,1) = 0          |          0


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     2     |            0              |               0               |          0
      3     |     1     |     2     |     can't take item       |         F(1-1,2) = 0          |          0
      4     |     2     |     2     |     can't take item       |         F(2-1,2) = 0          |          0
      7     |     3     |     2     |     can't take item       |         F(3-1,2) = 0          |          0


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     3     |            0              |               0               |          0
      3     |     1     |     3     |     F(1-1,3-3) = 1        |         F(1-1,3) = 0          |          1
      4     |     2     |     3     |     can't take item       |         F(2-1,3) = 1          |          1
      7     |     3     |     3     |     can't take item       |         F(3-1,3) = 1          |          1


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     4     |            0              |               0               |          0
      3     |     1     |     4     |     F(1-1,4-3) = 0        |         F(1-1,4) = 0          |          0
      4     |     2     |     4     |     F(2-1,4-4) = 1        |         F(2-1,4) = 0          |          1
      7     |     3     |     4     |     can't take item       |         F(3-1,4) = 1          |          1


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     5     |            0              |               0               |          0
      3     |     1     |     5     |     F(1-1,5-3) = 0        |         F(1-1,5) = 0          |          0
      4     |     2     |     5     |     F(2-1,5-4) = 0        |         F(2-1,5) = 0          |          0
      7     |     3     |     5     |     can't take item       |         F(3-1,5) = 0          |          0


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     6     |            0              |               0               |          0
      3     |     1     |     6     |     F(1-1,6-3) = 0        |         F(1-1,6) = 0          |          0
      4     |     2     |     6     |     F(2-1,6-4) = 0        |         F(2-1,6) = 0          |          0
      7     |     3     |     6     |     can't take item       |         F(3-1,6) = 0          |          0


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     7     |            0              |               0               |          0
      3     |     1     |     7     |     F(1-1,7-3) = 0        |         F(1-1,7) = 0          |          0
      4     |     2     |     7     |     F(2-1,7-4) = 1        |         F(2-1,7) = 0          |          1
      7     |     3     |     7     |     F(3-1,7-7) = 1        |         F(3-1,7) = 0          |          1



    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     8     |            0              |               0               |          0
      3     |     1     |     8     |     F(1-1,8-3) = 0        |         F(1-1,8) = 0          |          0
      4     |     2     |     8     |     F(2-1,8-4) = 0        |         F(2-1,8) = 0          |          0
      7     |     3     |     8     |     F(3-1,8-7) = 0        |         F(3-1,8) = 0          |          0



    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |     9     |            0              |               0               |          0
      3     |     1     |     9     |     F(1-1,9-3) = 0        |         F(1-1,9) = 0          |          0
      4     |     2     |     9     |     F(2-1,9-4) = 0        |         F(2-1,9) = 0          |          0
      7     |     3     |     9     |     F(3-1,9-7) = 0        |         F(3-1,9) = 0          |          0


    Item    |   Index   |   Sum     |       Taking the item     |       Not taking the item     |       Result
  ----------|-----------|-----------|---------------------------|-------------------------------|-----------------
      0     |     0     |    10     |            0              |               0               |          0
      3     |     1     |    10     |     F(1-1,10-3) = 0       |         F(1-1,10) = 0         |          0
      4     |     2     |    10     |     F(2-1,10-4) = 0       |         F(2-1,10) = 0         |          0
      7     |     3     |    10     |     F(3-1,10-7) = 1       |         F(3-1,10) = 0         |          1

    So sum of 10 is possible from a subset of [0,3,4,7]

 */
public class SubsetProblem {
    private int sum;
    private int[] values;
    private boolean[][] dpTable;

    public SubsetProblem(int sum, int[] values) {
        this.sum = sum;
        this.values = values;
        this.dpTable = new boolean[values.length + 1][sum + 1];
        // we can accomplish a sum of 0
        // so there is a valid subset
        // hence we are setting the value to true
        for (int i = 0; i < values.length + 1; i++)
            dpTable[i][0] = true;
    }

    // if we already have a solution from other elements,
    // we have already solved the problem
    public void solve() {
        for (int i = 0; i < values.length + 1; i++)
            dpTable[i][0] = true;

        for (int currentItemIndex = 1; currentItemIndex < values.length + 1; currentItemIndex++) {
            for (int currentSum = 1; currentSum < sum + 1; currentSum++) {

                // if current item is greater that the required sum,
                // then we cannot fit the item into the subset
                if (currentSum < values[currentItemIndex - 1]) {
                    // item not included
                    dpTable[currentItemIndex][currentSum] = dpTable[currentItemIndex - 1][currentSum];
                } else {
                    // if the problem is already solved and we have found
                    // the solution, so we copy the value from above
                    // there is no need to include this item not
                    if (dpTable[currentItemIndex - 1][currentSum]) {
                        // we don't include that item
                        dpTable[currentItemIndex][currentSum] = dpTable[currentItemIndex - 1][currentSum];
                    } else {
                        // now we include the item by checking
                        // if we exclude the current item from the current sum
                        // we have already solved that problem
                        // so we copy the result of that
                        dpTable[currentItemIndex][currentSum] =
                                dpTable[currentItemIndex - 1][currentSum - values[currentItemIndex - 1]];
                    }
                }
            }
        }
    }

    public boolean solveRecursive(int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }
        if (currentIndex == 0) {
            return false;
        }
        if (sum < values[currentIndex]) {
            return solveRecursive(sum, currentIndex - 1);
        } else {
            return solveRecursive(sum - values[currentIndex], currentIndex - 1) || solveRecursive(sum, currentIndex - 1);
        }
    }

    public void showResult() {
        System.out.println("There is a feasible solution " + dpTable[values.length][sum]);
        if (!dpTable[values.length][sum]) {
            return;
        }
        int colIndex = this.sum;
        int rowIndex = this.values.length;

        while (rowIndex > 0 || colIndex > 0) {
            if (dpTable[rowIndex][colIndex] == dpTable[rowIndex - 1][colIndex]) {
                rowIndex--;
            } else {
                System.out.println("We take the item : " + values[rowIndex - 1]);
                colIndex = colIndex - values[rowIndex - 1];
                rowIndex--;
            }
        }
    }
}
