package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EfficientMergeTwoSortedArray {

    public static int nextGap(int gap) {

        if (gap <= 1)
            return 0;
        return (int) Math.ceil(gap / 2);

    }

    public static void main(String[] args) throws IOException {

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

            int gap = X + Y, i, j;

            for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

                for (i = 0; i + gap < X; i++) {

                    if (arr1[i] > arr1[i + gap]) {
                        int tmp = arr1[i];
                        arr1[i] = arr1[i + gap];
                        arr1[i + gap] = tmp;
                    }

                }

                for (j = gap > X ? gap - X : 0; i < X && j < Y; i++, j++) {

                    if (arr1[i] > arr2[j]) {
                        int temp = arr1[i];
                        arr1[i] = arr2[j];
                        arr2[j] = temp;
                    }

                }

                if (j < Y)
                {

                    for (j = 0; j + gap < Y; j++)
                        if (arr2[j] > arr2[j + gap]) {
                            int temp = arr2[j];
                            arr2[j] = arr2[j + gap];
                            arr2[j+gap] = temp;
                        }
                }

            }

            for (i = 0; i < X; i++)
                System.out.print(arr1[i] + " ");

            for (i = 0; i < Y; i++) {
                System.out.print(arr2[i]);
                if (i != Y - 1)
                    System.out.print(" ");
            }

            if (t != 0)
                System.out.println();

        }

    }

}
