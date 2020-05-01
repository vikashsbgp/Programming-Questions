package geeksforgeeks.array;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CountTriplets {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine());

            String[] str = br.readLine().trim().split(" ");
            Set<Integer> hs = new HashSet<Integer>();

            for (int i = 0; i < N; i++) {

                hs.add(Integer.parseInt(str[i]));

            }

            int a = 0, b = 0, ans = 0;
            for (int i = 0; i < N - 1; i++) {

                a = Integer.parseInt(str[i]);
                for (int j = i + 1; j < N; j++) {

                     b = Integer.parseInt(str[j]);
                     if (hs.contains(a + b))
                         ans++;

                }

            }

            if (ans != 0)
                System.out.print(ans);
            else
                System.out.print("-1");

            if (t != 0)
                System.out.print("\n");

        }

        br.close();

    }

}
