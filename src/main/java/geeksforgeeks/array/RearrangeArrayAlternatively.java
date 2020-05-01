package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RearrangeArrayAlternatively {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().trim().split(" ");

            int arr[] = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(str[i]);

            int max_index = N - 1;
            int min_index = 0;
            int max_element = arr[max_index] + 1;

            for (int i = 0; i < N; i++) {

                if (i % 2 == 0) {
                    arr[i] += arr[max_index] % max_element * max_element;
                    max_index--;
                }
                else {
                    arr[i] += arr[min_index] % max_element * max_element;
                    min_index++;
                }

            }

            for (int i = 0; i < N; i++)
                System.out.print(arr[i]/max_element + " ");

        }

    }

}
