package hackerearth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Coordinate {

    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class TypingGame {

    private static String ans = "NO";

    public static void main(String[] args) throws IOException {

        String[] mat = {"mpkmlmp","fphufpd","bhfasdp","ruasaur","bmdimhb"};
        TypingGame obj = new TypingGame();
        System.out.print(obj.TypingKeyboard(mat, 5, 7, "saurbhmi"));

    }

    public String TypingKeyboard(String[] mat, int rows, int cols, String w){

        boolean vis[][];

        int index = 0;
        List<Coordinate> startIndex = new ArrayList<>();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (w.charAt(index) == mat[i].charAt(j)) {
                    startIndex.add(new Coordinate(i, j));
                }
            }
        }

        if (startIndex.size() == 0)
            return ans;
        else {

            for (Coordinate obj : startIndex) {
                vis = new boolean[rows][cols];
                dfs(mat, rows, cols, w, obj.x, obj.y, vis, 1);
                if (ans.equals("YES"))
                    return ans;
            }

        }

        return ans;

    }

    public void dfs(String[] mat, int rows, int cols, String w, int x, int y, boolean vis[][], int ind) {

        int rowNbr[] = {-1, 0, 0, 1};
        int colNbr[] = {0, -1, 1, 0};
        vis[x][y] = true;

        for (int i = 0; i < 4; ++i) {

            if (canMove(mat, rows, cols, w, x + rowNbr[i], y + colNbr[i], ind, vis)) {

                if (ind == w.length() - 1) {
                    ans = "YES";
                    return;
                }
                dfs(mat, rows, cols, w, x + rowNbr[i], y + colNbr[i], vis, ind + 1);

                if (ans.equals("YES"))
                    return;
            }

        }

    }

    public boolean canMove(String[] mat, int rows, int cols, String w, int x, int y, int ind, boolean[][] vis) {
        return (x >= 0) && (y >= 0) && (x < rows) && (y < cols) && (!vis[x][y]) && (mat[x].charAt(y) == w.charAt(ind));
    }

}
