package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine());
            String str[] = br.readLine().trim().split(" ");

            int arr[] = new int[N + 1];

            for (int i = 0; i < str.length; i++) {

                arr[Integer.parseInt(str[i])] = 1;

            }

            for (int i = 1; i <= N; i++) {

                if (arr[i] == 0) {

                    System.out.println(i);
                    break;

                }

            }

        }

    }

}
