package com.dsa.dp.coin_change;

public class Runner {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int targetAmount = 11;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.minCoins(coins, targetAmount));
        System.out.println(coinChange.minCoinsDP(coins, targetAmount));
        targetAmount = 5;
        System.out.println(coinChange.minCoins(coins, targetAmount));
        System.out.println(coinChange.minCoinsDP(coins, targetAmount));
        coins = new int[]{1, 3, 4, 5};
        targetAmount = 7;
        System.out.println(coinChange.minCoins(coins, targetAmount));
        System.out.println(coinChange.minCoinsDP(coins, targetAmount));
        coins = new int[]{2};
        targetAmount = 3;
        System.out.println(coinChange.minCoins(coins, targetAmount));
        System.out.println(coinChange.minCoinsDP(coins, targetAmount));
    }
}
