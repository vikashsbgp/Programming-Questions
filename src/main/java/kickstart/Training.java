package kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class EntryComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Map.Entry<Integer, Integer> entry1 = (Map.Entry<Integer, Integer>) o1;
        Map.Entry<Integer, Integer> entry2 = (Map.Entry<Integer, Integer>) o2;
        if (entry1.getValue() < entry2.getValue())
            return 1;
        else if (entry1.getValue() > entry2.getValue())
            return -1;
        else
            return 0;
    }
}

public class Training {

    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int tmp = t;
        while (t-- > 0) {
            String[] np  = br.readLine().trim().split(" ");
            int n = Integer.parseInt(np[0]);
            int p = Integer.parseInt(np[1]);
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(str[i]);

            int ans = numberOfHours(arr, n, p);

            System.out.print("Case #" + (tmp - t) + ": " + ans);

            if (t != 0)
                System.out.println();

        }

    }

    private static int numberOfHours(int[] arr, int n, int p) {

        if (p == 1)
            return 0;

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n - 1; ++i)
            map.put(i, arr[i + 1] - arr[i]);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new EntryComparator());

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            pq.add(entry);

        int tmp = p;
        int[] tmpArr = new int[p];

        for (int i = 0; i < p; ++i) {
            int ind = pq.poll().getKey();
        }

        return 0;
    }

}
