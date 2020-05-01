package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort012InArray {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().trim().split(" ");
            int sortedArr[] = new int[N + 1];
            //arrForOne[] = new int[N + 1];
            //int arrForTwo[] = new int[N + 1];


            int count_of_zeroes = 0, count_of_ones = 0, count_of_twos = 0;

            for (int i = 0; i < N; i++) {

                int number = Integer.parseInt(str[i]);

                if (number == 0)
                    count_of_zeroes++;
                else if (number == 1)
                    count_of_ones++;
                else
                    count_of_twos++;
            }

            Arrays.fill(sortedArr, 0, count_of_zeroes , 0);
            Arrays.fill(sortedArr, count_of_zeroes , count_of_zeroes + count_of_ones , 1);
            Arrays.fill(sortedArr, count_of_zeroes + count_of_ones, count_of_zeroes + count_of_ones + count_of_twos , 2);

            for (int j = 0; j < N; j++) {
                System.out.print(sortedArr[j] + " ");
            }

        }

    }

}
