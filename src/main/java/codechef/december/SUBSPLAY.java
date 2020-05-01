package codechef.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SUBSPLAY {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            int[] arr = new int[26];
            int newans = 0, ans = 0;
            Arrays.fill(arr, 0, 25, -1);

            for (int i = 0; i < n; ++i) {

                char ch = str.charAt(i);
                int val = ch - 97;

                if (arr[val] != -1) {
                    newans = arr[val] + 1;
                    newans = newans + ((n - i) - 1);
                    if (newans >= ans)
                        ans = newans;
                }
                arr[val] = i;

            }

            System.out.print(ans);

            if (t != 0)
                System.out.println();

        }

    }

}
