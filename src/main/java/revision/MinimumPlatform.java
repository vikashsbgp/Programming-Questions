package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumPlatform {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str1 = br.readLine().trim().split(" ");
            String[] str2 = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            int[] dept = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(str1[i]);
                dept[i] = Integer.parseInt(str2[i]);
            }

            System.out.print(minimumPlatform(arr, dept, n));

            if (t != 0)
                System.out.println();

        }

    }

    private static int minimumPlatform(int[] arr, int[] dept, int n) {
        int platformNeeded = 1;
        int maxCount = 0;

        Arrays.sort(arr);
        Arrays.sort(dept);

        for (int i = 1, j = 0; i < n && j < n;) {

            if (arr[i] <= dept[j]) {
                platformNeeded++;
                i++;
            }
            else if (arr[i] > dept[j]) {
                platformNeeded--;
                j++;
            }
            maxCount = Math.max(platformNeeded, maxCount);

        }

        return maxCount;
    }

}
