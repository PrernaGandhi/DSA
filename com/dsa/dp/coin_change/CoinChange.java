package com.dsa.dp.coin_change;

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
    target amount - 11
    output - minimum number of coins required =>  3
    explanation - 5 + 5 + 1

    1 => 1 => 1 =>
              2 =>
              5 =>
         2 =>
         5 =>
    2 =>
    5 =>


    coins - [1, 3, 4, 5]
    target amount - 7
    output => 2


    coins - [2]
    target amount - 3
    output - minimum number of coins required => -1



 */
public class CoinChange {
    private int minCoinss(int[] coins, int targetAmount) {
        if (targetAmount == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (targetAmount - coin >= 0) {
                int val = minCoinss(coins, targetAmount - coin);
                if (result > val) {
                    result = 1 + val;
                }
            }
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    public int minCoins(int[] coins, int targetAmount) {
        return minCoinss(coins, targetAmount);
    }

    private int minCoinssDP(int[] coins, int targetAmount, Map<Integer, Integer> map) {
        if (targetAmount == 0) {
            return 0;
        }
        if (map.containsKey(targetAmount)) {
            return map.get(targetAmount);
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (targetAmount - coin >= 0) {
                int val = minCoinssDP(coins, targetAmount - coin, map);
                if (result > val) {
                    result = 1 + val;
                }
            }
        }
        map.put(targetAmount, result);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    public int minCoinsDP(int[] coins, int targetAmount) {
        Map<Integer, Integer> map = new HashMap<>();
        return minCoinssDP(coins, targetAmount, map);
    }
}
