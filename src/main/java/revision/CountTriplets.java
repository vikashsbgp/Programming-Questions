package main.java.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CountTriplets {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; ++i)
                set.add(Integer.parseInt(str[i]));

            System.out.print(countTriplets(str, set, n));

            if (t != 0)
                System.out.println();
        }
    }

    public static int countTriplets(String[] str, Set<Integer> set, int n) {

        int count = 0;
        for (int i = 0; i < n; ++i) {

            for (int j = i + 1; j < n; ++j) {

                int a = Integer.parseInt(str[i]);
                int b = Integer.parseInt(str[j]);

                if (set.contains(a + b))
                    ++count;

            }

        }

        count = count == 0 ? -1 : count;

        return count;

    }

}
