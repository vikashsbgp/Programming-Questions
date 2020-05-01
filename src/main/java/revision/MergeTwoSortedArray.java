package main.java.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoSortedArray {

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

            mergeTwoSortedArray(arr1, arr2, n ,m);

            if (t != 0)
                System.out.println();
        }
    }

    public static void mergeTwoSortedArray(int[] arr1, int[] arr2, int n, int m) {

        int total = n + m;
        int tmp = 0;
        while (total > 1) {

            total = (int) Math.ceil(total / 2);
            for (int i = 1, j = total + i; j <= n + m; ++i, ++j) {

                // both ptr are in 1st array
                if (i <= n && j <= n) {
                    if (arr1[i] > arr1[j]) {
                        tmp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = tmp;
                    }
                }
                // both ptr are in 2nd array
                else if (i > n && j <= n + m) {
                    if (arr2[i - n] > arr2[j - n]) {
                        tmp = arr2[i - n];
                        arr2[i - n] = arr2[j - n];
                        arr2[j - n] = tmp;
                    }
                }
                // 1st ptr is in 1st array and 2nd ptr is in 2nd array
                else {
                    if (arr1[i] > arr2[j - n]) {
                        tmp = arr1[i];
                        arr1[i] = arr2[j - n];
                        arr2[j - n] = tmp;
                    }
                }
            }

        }

        for (int i = 1; i <= n + m; ++i) {
            if (i > n) {
                System.out.print(arr2[i - n]);
            }
            else {
                System.out.print(arr1[i]);
            }
            if (i != n + m)
                System.out.print(" ");
        }

    }

}
