package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiltMilk {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String[] str1 = br.readLine().trim().split(" ");
            String[] str2 = br.readLine().trim().split(" ");

            int[] maxVol = new int[n];
            int[] initVol = new int[n];
            int spiltMilkVol = 0;

            for (int i = 0; i < n; ++i) {

                maxVol[i] = Integer.parseInt(str1[i]);
                initVol[i] = Integer.parseInt(str2[i]);

            }

            for (int i = 1; i < n; ++i) {

                int totalMilkVol = initVol[i] + initVol[i - 1];

                if (totalMilkVol < maxVol[i])
                    initVol[i] = totalMilkVol;
                else {
                    initVol[i] = maxVol[i];
                    spiltMilkVol += totalMilkVol - maxVol[i];
                }

            }

            System.out.print(initVol[n - 1] + " " + spiltMilkVol);

            if (t != 0)
                System.out.println();

        }

    }

}
