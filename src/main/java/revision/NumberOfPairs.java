package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfPairs {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] nm = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] str1 = br.readLine().trim().split(" ");
            String[] str2 = br.readLine().trim().split(" ");
            int[] arr1 = new int[n + 1];
            int[] arr2 = new int[m + 1];
            for (int i = 0; i < n; ++i)
                arr1[i + 1] = Integer.parseInt(str1[i]);
            for (int i = 0; i < m; ++i)
                arr2[i + 1] = Integer.parseInt(str2[i]);

            System.out.print(numberOfPairs(arr1, arr2, n ,m));

            if (t != 0)
                System.out.println();
        }

    }

    public static int numberOfPairs(int[] arr1, int[] arr2, int n, int m) {

        int count = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (arr2[i] == 1 && arr1[j] != 1) {
                    count++;
                }
                else if (arr1[j] < arr2[i] && arr1[j] != 2 && arr2[i] != 3) {
                    count++;
                }
            }
        }

        return count;

    }

}
