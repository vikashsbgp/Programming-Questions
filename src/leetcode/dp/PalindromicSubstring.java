package leetcode.dp;

public class PalindromicSubstring {

    public int solve(int i, int j, String s, int[][] dp, boolean[][] visited) {

        //int ans = dp[i][j];
        if (i > j)
            return 1;
        if (i == j)
            return dp[i][j] = 1;
        if (visited[i][j])
            return dp[i][j];
        visited[i][j] = true;

        if (s.charAt(i) != s.charAt(j))
            return dp[i][j] = 0;
        return dp[i][j]  = solve(i + 1, j - 1, s, dp, visited);

    }

    public int countSubstrings(String s) {

        int n = s.length(), ans = 0;
        int dp[][] = new int[n][n];
        boolean visited[][] = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                ans += solve(i, j, s, dp, visited);
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstring ps = new PalindromicSubstring();
        System.out.print(ps.countSubstrings("fdsklf"));
    }

}
