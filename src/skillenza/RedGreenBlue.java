package skillenza;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedGreenBlue {

    public static int countSubsequence(int[] arr, int n) {

        int count = 1;
        boolean flag = false;
        Set<Integer> possible = new HashSet<>();
        possible.add(-2);
        possible.add(1);

        List<Integer> ans = new ArrayList<>();
        int diff = 0;

        for (int i = 1; i < n; i++) {

            diff = arr[i] - arr[i - 1];
            if (possible.contains(diff)) {
                ++count;
                flag = false;
            }
            else {
                if (count != 1) {
                    ans.add(count);
                    flag = true;
                }
                count = 1;
            }

        }

        if (!flag && count != 0)
            ans.add(count);

        int sum = 0;
        for (int e : ans) {
            if (e >= 3) {
                sum += ((e - 2) * (e - 1)) / 2;
            }
        }

        return sum;

    }

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                int n = Integer.parseInt(br.readLine().trim());
                String str = br.readLine().trim();
                int arr[] = new int[n];

                for (int i = 0; i < n; i++) {
                    if (str.charAt(i) == 'r')
                        arr[i] = 1;
                    else if (str.charAt(i) == 'g')
                        arr[i] = 2;
                    else if (str.charAt(i) == 'b')
                        arr[i] = 3;
                }

                System.out.print(countSubsequence(arr, arr.length));

                if (t != 0)
                    System.out.println();
            }

        }
        catch (Exception e) {

        }

    }

}
