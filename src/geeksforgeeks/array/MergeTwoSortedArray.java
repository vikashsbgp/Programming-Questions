package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MergeTwoSortedArray {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String XY[] = br.readLine().trim().split(" ");
            int X = Integer.parseInt(XY[0]);
            int Y = Integer.parseInt(XY[1]);

            String str1[] = br.readLine().trim().split(" ");
            String str2[] = br.readLine().trim().split(" ");

            int arr1[] = new int[X];
            int arr2[] = new int[Y];

            for (int i = 0; i < X; i++)
                arr1[i] = Integer.parseInt(str1[i]);

            for (int i = 0; i < Y; i++)
                arr2[i] = Integer.parseInt(str2[i]);

            int last_index = X - 1;

            for (int i = Y - 1; i >= 0; i--) {

                int j = last_index;
                if (arr2[i] < arr1[last_index]) {

                    int tmp = arr2[i];
                    arr2[i] = arr1[last_index];

                    while (tmp < arr1[j] && j > 0) {

                        arr1[j] = arr1[--j];

                    }

                    if (j == 0 && tmp < arr1[j])
                        arr1[j] = tmp;
                    else
                        arr1[++j] = tmp;

                }

            }

            for (int i = 0; i < X; i++)
                System.out.print(arr1[i] + " ");

            for (int i = 0; i < Y; i++) {
                System.out.print(arr2[i]);
                if (i != Y - 1)
                    System.out.print(" ");
            }

            if (t != 0)
                System.out.println();

        }

    }

}
