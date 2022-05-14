package com.dsa.dp.rodcutting;

public class RodCutting {
    private int rodLength;

    private int [][] dpTable;
    private int [] price;
    public RodCutting(int [] price, int rodLength) {
        this.rodLength = rodLength;
        this.dpTable = new int[this.rodLength + 1][this.rodLength + 1];
        this.price = price;
    }

    public int solution () {
      for(int i = 1; i < price.length; i++) {
          for(int j = 1; j < rodLength + 1; j ++) {
                  if (i <= j)
                      dpTable[i][j] = Math.max(price[i] + dpTable[i][j - i], dpTable[i - 1][j]);
                  else
                      dpTable[i][j] = dpTable[i -1][j];
          }
      }
      return dpTable[price.length - 1][rodLength];
    }

    public void showSolution() {
        System.out.println("Optimal Profit : $ " + dpTable[price.length - 1][rodLength]);

        for(int rowIndex = price.length -1 , colIndex = rodLength;rowIndex > 0;) {
            if(dpTable[rowIndex][colIndex] != 0 && dpTable[rowIndex][colIndex] != dpTable[rowIndex - 1][colIndex]) {
                System.out.println("We use piece " + rowIndex + ".");
                colIndex = colIndex - rowIndex;
            } else {
                rowIndex --;
            }
        }
    }

    public int solveRecursive(int rodLength, int i) {
        if(rodLength == 0 || i == 0) {
            return 0;
        }
        if(i > rodLength)
            return solveRecursive(rodLength, i - 1);
        int included = price[i] + solveRecursive(rodLength - i, i - 1);
        int excluded = solveRecursive(rodLength, i - 1);
        int result = Math.max(included, excluded);
        return result;
    }

    public int solveMemoizedRecursive(int rodLength, int i) {
        int result = 0;
        if(dpTable[i][rodLength] != 0)
            return dpTable[i][rodLength];
        if(rodLength == 0 || i == 0) {
            result = 0;
        } else if (i > rodLength){
            result = solveMemoizedRecursive(rodLength, i - 1);
        } else {
            int included = price[i] + solveMemoizedRecursive(rodLength - i, i - 1);
            int excluded = solveMemoizedRecursive(rodLength, i - 1);
            result = Math.max(included, excluded);
        }
        dpTable[i][rodLength] = result;
        return result;
    }
}
