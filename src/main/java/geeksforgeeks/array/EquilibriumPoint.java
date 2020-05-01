package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumPoint {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(str[i]);
                sum += arr[i];
            }

            int leftSum = 0, ans = 0;

            for (int i = 0; i < N; i++) {

                sum -= arr[i];

                if (leftSum == sum) {
                    ans = i + 1;
                    break;
                }
                leftSum += arr[i];

            }

            if (ans == 0)
                System.out.println("-1");
            else
                System.out.println(ans);
        }

    }

}
