package leetcode.string;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if (s != null && s.equals(p)) return true;
        char[] ss = s.toCharArray(), ps = p.toCharArray();
        int ls = ss.length, lp = ps.length;

        boolean[][] dp = new boolean[lp + 1][ls + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lp; i++)
            dp[i][0] = i > 1 && ps[i - 1] == '*' && dp[i - 2][0];
        for (int i = 1; i <= lp; i++) {
            if (ps[i - 1] == '*') {
                for (int j = 1; j <= ls; j++) {
                    dp[i][j] = (i > 1 && dp[i - 2][j]) || (dp[i][j - 1] && (ps[i - 2] == '.' || ps[i - 2] == ss[j - 1]));
                }
            } else {
                for (int j = 1; j <= ls; j++)
                    dp[i][j] = dp[i - 1][j - 1] && (ps[i - 1] == '.' || ps[i - 1] == ss[j - 1]);
            }
        }
        return dp[lp][ls];

    }

    public static void main(String[] args) {

        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.print(rem.isMatch("aaa", "ab*a*c*a"));

    }

}
