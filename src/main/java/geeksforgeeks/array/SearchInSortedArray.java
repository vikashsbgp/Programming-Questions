package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchInSortedArray {

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            int key = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);

            int pivot = 0;

            for (int i = 1; i < n; i++) {

                if (arr[i - 1] > arr[i])
                    pivot = i;

            }
            int ans = -1;
            if (key >= arr[pivot] && key > arr[0])
                ans = Arrays.binarySearch(arr, 0, pivot, key);

            else if (key >= arr[pivot] && key < arr[0])
                ans = Arrays.binarySearch(arr, pivot, n, key);

            else if (key == arr[pivot])
                ans = pivot;

            else
                ans = -1;

            if (ans < 0)
                System.out.print("-1");
            else
                System.out.print(ans);

            if (t != 0)
                System.out.println();


        }
    }

}
