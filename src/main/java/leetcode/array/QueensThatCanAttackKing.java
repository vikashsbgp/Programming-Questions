package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueensThatCanAttackKing {

    private int KX, KY;
    private Map<String, List<Integer>> dir = new HashMap<>();
    public List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {

        int n = queens.length;
        KX = king[0];
        KY = king[1];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++)
            solve(queens[i][0], queens[i][1]);

            if (dir.containsKey("N"))
                ans.add(dir.get("N"));
            if (dir.containsKey("E"))
                ans.add(dir.get("E"));
            if (dir.containsKey("W"))
                ans.add(dir.get("W"));
            if (dir.containsKey("S"))
                ans.add(dir.get("S"));
            if (dir.containsKey("NE"))
                ans.add(dir.get("NE"));
            if (dir.containsKey("NW"))
                ans.add(dir.get("NW"));
            if (dir.containsKey("SE"))
                ans.add(dir.get("SE"));
            if (dir.containsKey("SW"))
                ans.add(dir.get("SW"));


        return ans;

    }

    private void solve(int x, int y) {

        List<Integer> tmp = new ArrayList<>();
        // East
        if (KX == x && KY < y) {

            if (dir.containsKey("E")) {
                if (dir.get("E").get(1) > y)
                    dir.get("E").set(1,y);

            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("E", tmp);
            }
        }

        //West
        else if (KX == x && KY > y) {

            if (dir.containsKey("W")) {
                if (dir.get("W").get(1) < y)
                    dir.get("W").set(1,y);
            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("W", tmp);
            }
        }

        //North
        else if (KX > x && KY == y) {

            if (dir.containsKey("N")) {
                if (dir.get("N").get(0) < x)
                    dir.get("N").set(0,x);
            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("N", tmp);
            }
        }

        //South
        else if (KX < x && KY == y) {

            if (dir.containsKey("S")) {
                if (dir.get("S").get(0) > x)
                    dir.get("S").set(0,x);
            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("S", tmp);
            }
        }

        //NorthEast
        else if (KX > x && KY < y && KX - x == y - KY) {

            if (dir.containsKey("NE")) {
                if (dir.get("NE").get(0) < x) {
                    dir.get("NE").set(0, x);
                    dir.get("NE").set(1, y);
                }
            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("NE", tmp);
            }
        }

        //NorthWest
        else if (KX > x && KY > y && KX - x == KY - y) {

            if (dir.containsKey("NW")) {
                if (dir.get("NW").get(0) < x) {
                    dir.get("NW").set(0, x);
                    dir.get("NW").set(1, y);
                }
            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("NW", tmp);
            }
        }

        //SouthEast
        else if (KX < x && KY < y && x - KX == y - KY) {

            if (dir.containsKey("SE")) {
                if (dir.get("SE").get(0) > x) {
                    dir.get("SE").set(0, x);
                    dir.get("SE").set(1, y);
                }
            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("SE", tmp);
            }
        }

        //SouthWest
        else if (KX < x && KY > y && x - KX == KY - y) {

            if (dir.containsKey("SW")) {
                if (dir.get("SW").get(0) > x) {
                    dir.get("SW").set(0, x);
                    dir.get("SW").set(1, y);
                }
            }
            else {
                tmp.add(x);
                tmp.add(y);
                dir.put("SW", tmp);
            }
        }

    }

    public static void main(String[] args) {

        int[][] queens = {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[] king = {3,3};
        QueensThatCanAttackKing qtcak = new QueensThatCanAttackKing();
        System.out.print(qtcak.queensAttackTheKing(queens, king));

    }

}
