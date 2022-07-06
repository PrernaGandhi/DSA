package com.dsa.dp.coin_change_2;

public class Runner {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int targetAmount = 5;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.minCoins(coins, targetAmount));
        System.out.println(coinChange.minCoinsDP(coins, targetAmount));

        coins = new int[]{2};
        targetAmount = 7;
        System.out.println(coinChange.minCoins(coins, targetAmount));
        System.out.println(coinChange.minCoinsDP(coins, targetAmount));

    }
}
