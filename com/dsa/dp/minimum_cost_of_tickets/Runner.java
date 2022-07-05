package com.dsa.dp.minimum_cost_of_tickets;

public class Runner {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] cost = {2, 7, 15};
        MinimumCostOfTickets minimumCostOfTickets = new MinimumCostOfTickets();
        System.out.println(minimumCostOfTickets.minCost(days, cost));
        System.out.println(minimumCostOfTickets.minCostDP(days, cost));
        days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        System.out.println(minimumCostOfTickets.minCost(days, cost));
        System.out.println(minimumCostOfTickets.minCostDP(days, cost));
    }
}
