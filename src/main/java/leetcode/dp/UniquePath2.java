package main.java.leetcode.dp;

public class UniquePath2 {

    private int[][] dp;
    private boolean[][] vis;

    public static void main(String[] args) {
        int m = 7, n = 3;
        UniquePath2 up2 = new UniquePath2();
        System.out.println(up2.uniquePath(m, n));
    }

    private int uniquePath(int m, int n) {

        dp = new int[m + 1][n + 1];
        vis = new boolean[m + 1][n + 1];
        return dfs(m, n);
    }

    private int dfs(int m, int n) {

        if (m == 1 && n == 1) {
            dp[m][n] = 1;
        }
        else if (m < 1 || n < 1)
            return 0;
        else {

            if (vis[m][n])
                return dp[m][n];
            else {
                dp[m][n] = dfs(m - 1, n) + dfs(m, n - 1);
                vis[m][n] = true;
            }

        }
        return dp[m][n];

    }

}
