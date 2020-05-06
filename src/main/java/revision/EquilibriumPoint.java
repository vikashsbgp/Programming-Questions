package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; ++i)
                arr[i + 1] = Integer.parseInt(str[i]);

            System.out.print(equilibriumPoint(arr, n));

            if (t != 0)
                System.out.println();

        }
    }

    public static int equilibriumPoint(int[] arr, int n) {

        int leftsum = 0, sum = 0;

        for (int i = 1; i <= n; ++i)
            sum += arr[i];


        for (int i = 1; i <= n; ++i) {
            sum -= arr[i];

            if (leftsum == sum)
                return i;

            leftsum += arr[i];
        }

        return -1;

    }

}
