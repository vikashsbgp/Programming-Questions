package geeksforgeeks.array;

import java.io.*;

public class SubarraySum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String ns[] = br.readLine().trim().split(" ");
            int N = Integer.parseInt(ns[0]);
            int S = Integer.parseInt(ns[1]);

            String str[] = br.readLine().trim().split(" ");
            int[] arr = new int [N + 1];

            for (int i = 1; i <= N; i++) {

                arr[i] = Integer.parseInt(str[i - 1]);

            }

            int sum = 0;
            int leftIndex = 1;
            int rightIndex = 0;
            boolean flag = false;

            for (int i = 1, j = i; i <= N; i++) {

                while (sum < S && j <= N) {

                    sum += arr[j++];

                }

                if (sum == S) {

                    leftIndex = i;
                    rightIndex = --j;
                    flag = true;
                    break;

                }
                else {

                    sum -= arr[i];

                }

            }

            if (flag)
                bw.write(leftIndex + " " + rightIndex);
            else
                bw.write("-1");

            if (t != 0)
                bw.write("\n");

        }

        br.close();
        bw.close();

    }

}
