package revision;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; ++i)
                arr[i + 1] = Integer.parseInt(str[i]);

            leadersInArray(arr, n);

            if (t != 0)
                System.out.println();

        }
    }

    public static void leadersInArray(int[] arr, int n) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int leaderElement = Integer.MIN_VALUE;
        List<Integer> leadersArray = new ArrayList<>();
        for (int i = n; i > 0; --i) {

            if (leaderElement <= arr[i]) {
                leaderElement = arr[i];
                leadersArray.add(leaderElement);
            }

        }

        Collections.reverse(leadersArray);

        for (int i = 0; i < leadersArray.size(); ++i) {

            bw.write(leadersArray.get(i) + "");

            if (i != leadersArray.size() - 1)
                bw.write(" ");
        }

        bw.close();

    }

}
