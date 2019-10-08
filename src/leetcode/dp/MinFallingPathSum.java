package leetcode.dp;

public class MinFallingPathSum {

    public static boolean isSafe(int[][] A, int row, int col, int ROW, int COL) {

        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    public int DFS(int[][] A, int[][] dp, int row, int col, int ROW, int COL, boolean[][] visited) {

        int path1 = 0, path2 = 0, path3 = 0;

        if (visited[row][col])
            return dp[row][col];

        visited[row][col] = true;

        if (isSafe(A, row + 1, col - 1, ROW, COL))
            path1 = DFS(A, dp, row + 1, col - 1, ROW, COL, visited);
        if (isSafe(A, row + 1, col, ROW, COL))
            path2 = DFS(A, dp, row + 1, col, ROW, COL, visited);
        if (isSafe(A, row + 1, col + 1, ROW, COL))
            path3 = DFS(A, dp, row + 1, col + 1, ROW, COL, visited);

        if (path1 == 0)
            dp[row][col] += Math.min(path2, path3);
        else  if (path2 == 0)
            dp[row][col] += Math.min(path1, path3);
        else if (path3 == 0)
            dp[row][col] += Math.min(path1, path2);
        else
            dp[row][col] += path1 < path2 ? (path1 < path3 ? path1 : path3) : (path2 < path3 ? path2 : path3);
        return dp[row][col];

    }

    public static int minFallingPathSum(int[][] A) {

        int ROW = A.length;
        int COL = ROW;

        int dp[][] = new int[ROW][COL];
        boolean visited[][] = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {

                dp[i][j] = A[i][j];
            }
        }

        MinFallingPathSum mfps = new MinFallingPathSum();

        for (int i = 0; i < COL; i++) {
            mfps.DFS(A, dp, 0, i, ROW, COL, visited);
        }

        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < COL; i++) {
            if (minPath > dp[0][i])
                minPath = dp[0][i];
        }
        return minPath;
    }

    public static void main(String[] args) {

        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(minFallingPathSum(arr));

    }

}
