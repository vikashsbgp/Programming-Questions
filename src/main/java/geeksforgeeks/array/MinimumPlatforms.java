package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


class TreeMapValue {
    char ch;
    int count;

    TreeMapValue(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
public class MinimumPlatforms {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine());
            String[] str1 = br.readLine().trim().split(" ");
            String[] str2 = br.readLine().trim().split(" ");
            TreeMap<String, TreeMapValue> allTrains = new TreeMap<>();

            for (int i = 0; i < N; i++) {

                if (allTrains.containsKey(str1[i])) {
                    ++allTrains.get(str1[i]).count;
                    allTrains.put(str1[i], allTrains.get(str1[i]));
                }
                else
                    allTrains.put(str1[i], new TreeMapValue('A', 1));
            }

            for (int i = 0; i < N; i++) {

                if (allTrains.containsKey(str2[i])) {
                    ++allTrains.get(str2[i]).count;
                    allTrains.put(str2[i], allTrains.get(str2[i]));
                }
                else
                    allTrains.put(str2[i], new TreeMapValue('D', 1));
            }

            int currCount = 0, prevCount = 0;
            for (Map.Entry<String, TreeMapValue> entry : allTrains.entrySet()) {

                String time = entry.getKey();
                TreeMapValue value = entry.getValue();

                if (value.ch == 'A')
                    currCount++;

                else {
                    if (prevCount < currCount)
                        prevCount = currCount;
                    currCount = 0;
                }
            }

            System.out.print(prevCount);
        }
    }

}
