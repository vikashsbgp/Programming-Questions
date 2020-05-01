package skillenza;

import java.util.LinkedList;
import java.util.Queue;

class Box {

    int x;
    int y;
    int time;
    boolean vis;

    Box(int x, int y, int time) {

        this.x = x;
        this.y = y;
        this.time = time;
        this.vis = false;

    }

}

public class VirusInfection {

    public static void main(String[] args) {

        VirusInfection obj = new VirusInfection();
        int n = 2, m = 3;
        int x = 1, y = 2;
        System.out.print(obj.getTime(n, m, x, y));

    }

    private int getTime(int n, int m, int x, int y) {

        int maxTime = 0;
        Queue<Box> adj = new LinkedList<>();
        Box start = new Box(x, y, 0);
        adj.add(start);

        int[] rowNbr = {-1, -1, -1, 0, 0, -1, -1, -1};
        int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};
        boolean[][] vis = new boolean[n + 1][m + 1];

        while (!adj.isEmpty()) {

            Box s = adj.poll();
            vis[s.x][s.y] = true;

            for (int i = 0; i < 8; i++) {

                if (canMove(n, m, x + rowNbr[i], y + colNbr[i], vis)) {
                    if (maxTime < s.time + 1)
                        maxTime = s.time + 1;
                    adj.add(new Box(x + rowNbr[i], y + colNbr[i], s.time + 1));
                }

            }

        }
        return maxTime;

    }

    private boolean canMove(int n, int m, int x, int y, boolean vis[][]) {
        return (x > 0) || (y > 0) && (x <= n) || (y <= m) && (!vis[x][y]);
    }

}
