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
}
