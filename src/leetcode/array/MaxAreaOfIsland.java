package leetcode.array;

public class MaxAreaOfIsland {

    private static int[][] dp;
    private static boolean[][] vis;
    private static int[] rowNext;
    private static int[] colNext;

    public int maxAreaOfIsland(int[][] grid) {

        int col = grid[0].length;
        int row = grid.length;
        int ans = 0, maxCount = -1;
        dp = new int[row][col];
        vis = new boolean[row][col];
        rowNext = new int[]{-1, 0, 0, 1};
        colNext = new int[]{0, -1, 1, 0};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] != 0 && !vis[i][j]) {
                    dp[i][j] = 1;
                    ans = solve(grid, row, col, i, j);
                }
                if (maxCount < ans)
                    maxCount = ans;

            }
        }

        return maxCount;
    }

    private int solve(int[][] grid, int ROW, int COL, int row, int col) {

        if (vis[row][col])
            return dp[row][col];
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            if (isSafe(grid, ROW, COL, row + rowNext[i], col + colNext[i]))
                dp[row][col] += grid[row][col] + solve(grid, ROW, COL, row + rowNext[i], col + colNext[i]);
        }
        return dp[row][col];

    }

    private boolean isSafe(int grid[][], int ROW, int COL, int row, int col) {

        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (grid[row][col] == 1) && !vis[row][col];

    }

    public static void main(String[] args) {

        int[][] mat = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        System.out.print(obj.maxAreaOfIsland(mat));

    }

}
