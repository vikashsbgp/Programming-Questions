package codechef.october;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MARM {

    public static void arrayModification(int[] arr, int n, long k) {

       if (k > n) {
            int repeat = 0;
            if (n % 2 == 0) {
                repeat = 3 * n;
                if (k >= repeat)
                    k = k % repeat;
            }
            else {
                int start_index = n / 2 + 1;
                repeat = (3 * n) + start_index;
                if (k >= repeat)
                    k = k % (3 * n);
            }

        }

        for (int i = 0; i < k; i++) {

            int a = arr[i % n];
            int b = arr[n - (i % n) - 1];
            arr[i % n] = a ^ b;

            /*System.out.print(i + 1 + "  ");
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j]);
                if (j != n - 1)
                    System.out.print(" ");
            }
            System.out.println();*/

        }

    }

    public static void main(String[] args) {

        try {

            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                String[] nk = br.readLine().trim().split(" ");
                int n = Integer.parseInt(nk[0]);
                long k = Long.parseLong(nk[1]);

                String[] str = br.readLine().trim().split(" ");
                int[] arr = new int[n];

                for (int i = 0; i < n; i++)
                    arr[i] = Integer.parseInt(str[i]);

                MARM.arrayModification(arr, n, k);

                for (int j = 0; j < n; j++) {
                    System.out.print(arr[j]);
                    if (j != n - 1)
                        System.out.print(" ");
                }

                if (t != 0)
                    System.out.println();

            }

        }
        catch (Exception e) {

        }

    }

}
