package Recursion.leetcode;

import java.util.*;

public class mincostclimbingstair_764 {

    static int solve(int i, int[] cost) {

        // Base case
        if (i >= cost.length) {
            return 0;
        }

        // Take 1 step or 2 steps
        return cost[i] + Math.min(
                solve(i + 1, cost),
                solve(i + 2, cost)
        );
    }

    public static int minCostClimbingStairs(int[] cost) {

        // We can start from index 0 or index 1
        return Math.min(
                solve(0, cost),
                solve(1, cost)
        );
    }

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};

        int result = minCostClimbingStairs(cost);

        System.out.println("Minimum cost = " + result);
    }
}
