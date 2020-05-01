package main.java.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithGivenSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] ns = br.readLine().trim().split(" ");
            int n = Integer.parseInt(ns[0]);
            int s = Integer.parseInt(ns[1]);
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; ++i)
                arr[i + 1] = Integer.parseInt(str[i]);

            subArrayWithGivenSum(arr, n ,s);

            if (t != 0)
                System.out.println();
        }
    }

    public static void subArrayWithGivenSum(int[] arr, int n, int s) {

        int i = 1, j = 1;
        while (i <= n && j <= n) {
            if (arr[j] < s) {
                s -= arr[j++];
            }
            else if (arr[j] > s) {
                s += arr[i++];
            }
            else {
                s -= arr[j];
                break;
            }
        }

        if (s == 0) {
            System.out.print(i + " " + j);
        } else {
            System.out.print("-1");
        }

    }

}
