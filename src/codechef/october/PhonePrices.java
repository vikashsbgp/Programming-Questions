package codechef.october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class PhonePrices {

    public int calculatePhonePrice(int[] arr) {

        int n = arr.length;
        Integer[] fivePacket = {Integer.MAX_VALUE,Integer.MAX_VALUE,
                Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};

        int ans  = -1, min_val = 0, quot = 0;
        int count = 0;

        for (int i = 1; i < n; i++) {

            fivePacket[(i-1) % 5] = arr[i - 1];
            quot = (i - 1) / 5;
            min_val = Collections.min(Arrays.asList(fivePacket));

            if (ans != min_val) {

                ans = min_val;
                count++;
            }
            else
                count += quot;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String s[] = br.readLine().trim().split(" ");
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);

            PhonePrices pp = new PhonePrices();
            System.out.print(pp.calculatePhonePrice(arr));

            if (t != 0)
                System.out.println();

        }

    }
}
