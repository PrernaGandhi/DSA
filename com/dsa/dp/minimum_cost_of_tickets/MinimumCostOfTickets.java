package com.dsa.dp.minimum_cost_of_tickets;

import java.util.HashMap;
import java.util.Map;

/*
    We have 2 arrays, one consisting of days from 1 to 365,
    and the other contains 3 elements, signifying,
    1 day pass value
    7 day pass value
    30 day pass value

    we need to determine the minimum cost of travelling based
    on the days we decide to go and the the value to pass

    days  = [1,4,6,7,8,20]
    cost = [2, 7, 15]

    output : 11

    7 day pass + 1 day pass + 1 day pass

    currIndex = 0, currDay = 1
    if I take 1 day pass, cost = $2, passCoverage = 0
    if I take 7 day pass, cost = $7, passCoverage = 7
    if I take 30 day pass, cost = $15, passCoverage = 30
    min = $2

    currIndex = 1, currDay = 4
    1 day => $2 + $2
    7 day => already covered => $7
    30 day => already covered => $15
    min = $4

    currIndex = 2, currDay = 6
    1 day => $4 +$2
    7 day => already covered => $7
    30 day => already covered => $15
    min = $6

    currIndex = 3, currDay = 7
    1 day => $6 + $2
    7 day coverage => already covered => $7
    30 day coverage => already covered => $15
    min = $7

    currIndex = 4, currDay = 8
    1 day => $7 + $2
    7 day => $7 + $7, passCoverage = 8 + 7 = 15
    30 day => already covered => $15
    min = $9

    currIndex = 5, currDay = 20
    1 day => $9 + $2
    7 day => $9 + $7
    30 day => already covered => $15
    min = $11

 */
public class MinimumCostOfTickets {

    public int minCostDP(int[] days, int[] cost, int currIndex, int passCoverage, Map<Integer, Integer> map) {
        if (currIndex == days.length) {
            return 0;
        }

        if (passCoverage > 0 && days[currIndex] < passCoverage) {
            return minCostDP(days, cost, currIndex + 1, passCoverage, map);
        }
        if (map.containsKey(currIndex)) {
            return map.get(currIndex);
        }
        int oneDayPass = cost[0] + minCostDP(days, cost, currIndex + 1, days[currIndex], map);
        int sevenDayPass = cost[1] + minCostDP(days, cost, currIndex + 1, days[currIndex] + 7, map);
        int thirtyDayPass = cost[2] + minCostDP(days, cost, currIndex + 1, days[currIndex] + 30, map);
        int val = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        map.put(currIndex, val);
        //System.out.println(passCoverage + " " + days[currIndex] + "  : " + oneDayPass + " " + sevenDayPass + " " + thirtyDayPass);
        return val;
    }

    public int minCostDP(int[] days, int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        return minCostDP(days, cost, 0, 0, map);
    }

    public int minCost(int[] days, int[] cost, int currIndex, int passCoverage) {
        if (currIndex == days.length) {
            return 0;
        }

        if (passCoverage > 0 && days[currIndex] < passCoverage) {
            return minCost(days, cost, currIndex + 1, passCoverage);
        }

        int oneDayPass = cost[0] + minCost(days, cost, currIndex + 1, days[currIndex]);
        int sevenDayPass = cost[1] + minCost(days, cost, currIndex + 1, days[currIndex] + 7);
        int thirtyDayPass = cost[2] + minCost(days, cost, currIndex + 1, days[currIndex] + 30);
        int val = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        //System.out.println(passCoverage + " " + days[currIndex] + "  : " + oneDayPass + " " + sevenDayPass + " " + thirtyDayPass);
        return val;
    }

    public int minCost(int[] days, int[] cost) {
        return minCost(days, cost, 0, 0);
    }
}
