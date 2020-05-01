package leetcode.dp;

public class UniquePaths {

    private static int[] dp;
    private static boolean[] vis;
    public int uniquePaths(int m, int n) {

        int start = m * n;
        dp = new int[m * n + 1];
        vis = new boolean[m * n + 1];
        return solve(m, n, start);

    }

    private int solve(int m, int n, int start) {

        int right = 0, down = 0;
        if (start <= 1)
            return 1;

        if (vis[start])
            return dp[start];
        vis[start] = true;

        if ((start - 1) % m != 0)
            right = solve(m, n, start - 1);
        if (start > m)
            down = solve(m, n, start - m);

        return dp[start] = right + down;

    }

    public static void main(String[] args) {

        int m = 7, n = 3;
        UniquePaths up = new UniquePaths();
        System.out.print(up.uniquePaths(m, n));

    }

}
