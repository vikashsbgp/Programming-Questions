package leetcode.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Grid {

    int count;
    StringBuilder sb;

    Grid (int count) {
        this.count = count;
        this.sb = new StringBuilder("");
    }

}

class Pair {

    int el1;
    int el2;

    Pair(int el1, int el2) {
        this.el1 = el1;
        this.el2 = el2;
    }

}

public class BaseCamp {

    private static Grid dp[][];
    private static boolean visited[][];
    private static int ROW;
    private static int COL;
    private static int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int colNbr[] = {0, -1, 1, -1 ,1, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BaseCamp obj = new BaseCamp();
        String[] str = br.readLine().trim().split(" ");
        ROW = Integer.parseInt(str[0]);
        COL = Integer.parseInt(str[1]);
        int[][] mat = new int[ROW][COL];
        List<Pair> ind = new ArrayList<>();
        dp = new Grid[ROW][COL];
        visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; ++i) {

            String s1 = br.readLine().trim();
            for (int j = 0; j < COL; ++j) {

                if (s1.charAt(j) == 'w')
                    mat[i][j] = 1;
                else if (s1.charAt(j) == 's') {
                    mat[i][j] = 0;
                    Pair pair = new Pair(i, j);
                    ind.add(pair);
                }
                else if (s1.charAt(j) == 'd')
                    mat[i][j] = 2;

            }

        }

        for (Pair pair:
             ind) {

            dfs(mat, pair.el1, pair.el2);

        }

    }

    private static Grid dfs(int[][] mat, int row, int col) {

        if (mat[row][col] == 2) {
            dp[row][col].count = 1;
            dp[row][col].sb.append(row + "" + col + "");
            return dp[row][col];
        }

        if (visited[row][col])
            return dp[row][col];

        visited[row][col] = true;

        for (int i = 0; i < 8; ++i) {

            if (isSafe(mat, row, col)) {
                dp[row][col].count += dfs(mat, row + rowNbr[i], col + colNbr[i]).count;
                dp[row][col].sb.append(dfs(mat, row + rowNbr[i], col + colNbr[i]).sb);
            }

        }

        return dp[row][col];
    }

    private static boolean isSafe(int[][] mat, int row, int col) {
        return (row >= ROW) || (col >= COL) || (mat[row][col] != 1) || (!visited[row][col]);
    }

}
