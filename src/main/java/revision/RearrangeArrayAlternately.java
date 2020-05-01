package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeArrayAlternately {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; ++i)
                arr[i + 1] = Integer.parseInt(str[i]);

            rearrangeArrayAlternately(arr, n);

            if (t != 0)
                System.out.println();

        }
    }

    // O(n^2)
    public static void rearrangeArrayAlternately(int[] arr, int n) {

        for (int i = 1; i <= n; i += 2) {     // O(n)
            rotate(arr, n, n - 1, i);      // O(n)
        }

        for (int i = 1; i <= n; ++i) {      // O(n)
            System.out.print(arr[i]);

            if (i != n)
                System.out.print(" ");
        }

    }

    //O(n)
    public static void rotate(int[] arr, int n, int d, int start) {

        reverse(arr, start, d);
        reverse(arr, d + 1, n);
        reverse(arr, start, n);

    }

    // O(n)
    public static void reverse(int[] arr, int start, int end) {

        int tmp = 0;
        while (start < end) {
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            ++start;
            --end;
        }

    }

}
