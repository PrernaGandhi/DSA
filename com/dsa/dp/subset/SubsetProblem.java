package com.dsa.dp.subset;

public class SubsetProblem {
    private int sum;
    private int [] values;
    private boolean [][] dpTable;

    public SubsetProblem(int sum, int [] values){
        this.sum = sum;
        this.values = values;
        this.dpTable = new boolean[values.length + 1][sum + 1];
    }

    public void solve() {
        // first row is false by default
        // so no need to set it
        // first row has false values
        // first column has true values
        for(int i = 0; i < values.length + 1;i++)
            dpTable[i][0] = true;

        for(int rowIndex = 1; rowIndex < values.length + 1; rowIndex++) {
            for(int colIndex = 1; colIndex < sum + 1; colIndex++) {
                // if colIndex is small , then we copy value above
                if(colIndex < values[rowIndex - 1]) {
                    dpTable[rowIndex][colIndex] = dpTable [rowIndex -1][colIndex];
                } else {
                    if(dpTable[rowIndex - 1][colIndex]) {
                        // we don't include that item
                        dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex];
                    } else {
                        dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex - values[rowIndex - 1]];
                    }
                }

            }
        }
    }

    public void showResult() {
        System.out.println("There is a feasible solution "  + dpTable[values.length][sum]);
        if(!dpTable[values.length][sum]) {
            return;
        }
        int colIndex = this.sum;
        int rowIndex = this.values.length;

        while(rowIndex > 0 || colIndex > 0) {
            if(dpTable[rowIndex][colIndex] == dpTable[rowIndex - 1][colIndex]) {
                rowIndex --;
            } else {
                System.out.println("We take the item : " + values[rowIndex - 1]);
                colIndex = colIndex - values[rowIndex - 1];
                rowIndex --;
            }
        }
    }
}
