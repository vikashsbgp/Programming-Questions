package leetcode.dp;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans = 0;

        int dp[] = new int[n];
        boolean vis[] = new boolean[n];

        return ans = go(cost, n - 1, dp, vis);
    }

    private int go(int[] cost, int i, int[] dp, boolean[] vis) {

        if (i == 0 || i == 1)
            return cost[i];

        if (vis[i])
            return dp[i];

        vis[i] = true;

        return dp[i] = cost[i] + Math.min(go(cost, i - 1, dp, vis), go(cost, i - 2, dp, vis));

    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        System.out.print(mccs.minCostClimbingStairs(cost));
    }
}
