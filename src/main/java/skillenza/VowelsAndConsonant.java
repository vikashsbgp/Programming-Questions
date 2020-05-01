package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class VowelsAndConsonant {

    private static Set<Character> vowels = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        vowels.add('a'); vowels.add('o');
        vowels.add('e'); vowels.add('u');
        vowels.add('i');

        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            VowelsAndConsonant vc = new VowelsAndConsonant();
            System.out.print(vc.countSubsequence(s));
            if (t != 0)
                System.out.println();
        }
    }

    public int countSubsequence(String s) {

        int n = s.length();
        int ans = 0;
        int dp[][] = new int[n][n];
        boolean vis[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans += solve(i, j, s, dp, vis);
            }
        }

        return ans;

    }

    public int solve(int i, int j, String s, int[][] dp, boolean[][] vis) {

        if (i > j)
            return 1;

        if (i == j)
            return dp[i][j] = 0;

        if (vis[i][j])
            return dp[i][j];

        vis[i][j] = true;

        if (vowels.contains(s.charAt(j - 1)) && vowels.contains(s.charAt(j)) ||
                !vowels.contains(s.charAt(j - 1)) && !vowels.contains(s.charAt(j))) {
            return dp[i][j] = 0;
        }

        if (j - 1 == i)
            return dp[i][j] = 1;
        return dp[i][j] = solve(i, j - 1, s, dp, vis);

    }

}
