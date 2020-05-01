package main.java.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadanesAlgorithm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(str[i]);

            System.out.print(maxSumSubArray(arr, n));

            if (t != 0)
                System.out.println();
        }
    }

    public static int maxSumSubArray(int[] arr, int n) {

        int maxSum = Integer.MIN_VALUE;
        int prevSum = 0, currSum = 0;

        for (int i = 0; i < n; ++i) {

            currSum = arr[i];
            currSum = Math.max(currSum, arr[i] + prevSum);
            maxSum = Math.max(maxSum, currSum);
            prevSum = currSum;

        }

        return maxSum;

    }

}
