package com.dsa.dp.coin_change_2;

import java.util.HashMap;
import java.util.Map;

/*
    we have coins of different denominations
    we can assume we have infinite coins of each kind
    we need to find the minimum number of coins
    required to make the target sum
    it is possible that the target sum can't
    be reached from the given denominations,
    then return -1

    coins - [1, 2, 5]
    target amount - 5
    output - number of ways we can create target amount =>  4
    explanation -
    1+1+1+1+1
    1+1+2+1
    2+2+1
    5
    Now this would be a combination question, as the order doesn't matter


    if target amount equals 0, we have found a solution

    coins - [2]
    target amount - 7
    output => 0

 */
public class CoinChange {
    private int minCoinss(int[] coins, int targetAmount, int currIndex) {
        if (targetAmount == 0) {
            return 1;
        }
        int result = 0;
        for (int index = currIndex; index < coins.length; index++) {
            if (targetAmount - coins[index] >= 0) {
                int val = minCoinss(coins, targetAmount - coins[index], index);
                result += val;
            }
        }
        return result;
    }

    public int minCoins(int[] coins, int targetAmount) {
        return minCoinss(coins, targetAmount, 0);
    }

    private int minCoinssDP(int[] coins, int targetAmount, int currIndex, Map<Integer, Integer> map) {
        if (map.containsKey(targetAmount)) {
            return map.get(targetAmount);
        }
        if (targetAmount == 0) {
            return 1;
        }
        int result = 0;
        for (int index = currIndex; index < coins.length; index++) {
            if (targetAmount - coins[index] >= 0) {
                int val = minCoinssDP(coins, targetAmount - coins[index], index, map);
                result += val;
            }
        }

        //System.out.println(targetAmount + " " + result);
        return result;
    }

    public int minCoinsDP(int[] coins, int targetAmount) {
        Map<Integer, Integer> map = new HashMap<>();
        return minCoinssDP(coins, targetAmount, 0, map);
    }
}