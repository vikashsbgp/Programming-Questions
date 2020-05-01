package main.java.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; ++i)
                arr[i] = Integer.parseInt(str[i]);

            System.out.print(missingNumber(arr, n));

            if (t != 0)
                System.out.println();

        }
    }

    private static int missingNumber(int[] arr, int n) {

        int totalSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < n - 1; ++i) {
            sum += arr[i];
        }

        return totalSum - sum;

    }

}
