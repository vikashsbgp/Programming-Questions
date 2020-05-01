package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Mark {

    int x;
    int y;

    Mark(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class MyNewComparator implements Comparator<Mark> {


    @Override
    public int compare(Mark o1, Mark o2) {
        return ((Integer)o1.x).compareTo((Integer)o2.x);

    }
}
public class NumberOfMarkers {

    public int getMarkers(PriorityQueue<Mark> coordinates, int n) {

        int ans = 0;
        Mark startObj = coordinates.poll();
        int startX = startObj.x;
        int startY = startObj.y;
        ans  = startY - startX + 1;

        for (int i = 1; i < n; ++i) {

            startObj = coordinates.poll();
            int x = startObj.x;
            int y = startObj.y;
            if (startY >= x && startY < y)
                ans += (y - startY);
            else if (startY < x)
                ans += (y - x) + 1;

            startX = x;
            if (startY < y)
                startY = y;

        }

        return ans;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            NumberOfMarkers obj = new NumberOfMarkers();
            PriorityQueue<Mark> coordinates = new PriorityQueue<>(new MyNewComparator());
            int n = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < n; ++i) {

                String[] xy = br.readLine().trim().split(" ");
                coordinates.add(new Mark(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));

            }

            System.out.print(obj.getMarkers(coordinates, n));
            if (t != 0)
                System.out.println();

        }

    }

}
