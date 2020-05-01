package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairSumInRotatedSortedArray {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            int sum = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);

            int pivot = 0;

            for (int i = 1; i < n; i++) {

                if (arr[i - 1] > arr[i])
                    pivot = i;

            }

            int start = pivot, end = pivot - 1;
            boolean ans = false;

            while (start != end) {

                if (arr[start] + arr[end] == sum) {
                    ans = true;
                    break;
                }
                else if (arr[start] + arr[end] < sum) {
                    start++;
                    if (start == n)
                        start = 0;
                }
                else if (arr[start] + arr[end] > sum) {
                    end--;
                    if (end == -1)
                        end = n - 1;
                }


            }

            System.out.print(ans);

            if (t != 0)
                System.out.println();

        }

    }

}
