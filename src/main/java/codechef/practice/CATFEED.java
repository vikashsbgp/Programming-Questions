package main.java.codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CATFEED {
    public static void main (String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                String s1[] = br.readLine().trim().split(" ");
                int N = Integer.parseInt(s1[0]);
                int M = Integer.parseInt(s1[1]);

                int[] arr = new int[M + 1];
                String s2[] = br.readLine().trim().split(" ");

                for (int i = 0; i < M; i++)
                    arr[i + 1] = Integer.parseInt(s2[i]);

                System.out.println(solve(arr, N, M));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String solve(int[] arr, int n, int m) {
        String ans = "";
        Set<Integer> hs = new HashSet<>();
        if (n > m) {

            for (int i = 1; i <= m; i++)
                hs.add(arr[i]);

            if (hs.size() != arr.length)
                ans = "NO";
            else
                ans = "YES";
        }
        else {

            int cats[] = new int[n + 1];
            for (int i = 1; i <= m; i++) {
                ++cats[arr[i]];
                if (i % n == 0) {
                    for (int j = 1; j <= n; j++)
                        hs.add(cats[j]);
                    if (hs.size() != 1)
                        ans = "NO";
                    break;
                }
            }

            if (ans.equals(""))
                ans = "YES";

        }

        return ans;
    }

}
