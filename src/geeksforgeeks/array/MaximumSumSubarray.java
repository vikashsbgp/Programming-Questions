package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumSubarray {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine());
            String str[] = br.readLine().trim().split(" ");
            int arr[] = new int[N + 1];

            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(str[i - 1]);

            int maxSum = arr[1];
            int currSum = 0;

            for (int i = 1; i <= N; i++) {

                currSum += arr[i];
                maxSum = Math.max(maxSum, currSum);

                if (currSum < 0)
                    currSum = 0;

            }

            System.out.println(maxSum);

        }


    }

}
