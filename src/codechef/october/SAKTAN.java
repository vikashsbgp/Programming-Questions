package codechef.october;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SAKTAN {

    public int operationOnMatrix(boolean[][] mat, int row, int col, int[][] query, int m) {

        int ans = 0;
        for (int i = 0; i < m; i++) {

            // changing row
            for (int j = 0; j < col; j++)
                mat[query[i][0] - 1][j] = mat[query[i][0] - 1][j] == true ? false:true;

            // changing column
            for (int j = 0; j < row; j++)
                mat[j][query[i][1] - 1] = mat[j][query[i][1] - 1] == true ? false:true;

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j])
                    ans++;
            }
        }

         return ans;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String s[] = br.readLine().trim().split(" ");
            int row = Integer.parseInt(s[0]);
            int col = Integer.parseInt(s[1]);
            int m = Integer.parseInt(s[2]);

            boolean[][] mat = new boolean[row][col];
            int[][] query = new int[m][2];

            for (int i = 0; i < m; i++) {

                String[] str = br.readLine().trim().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                query[i][0] = x;
                query[i][1] = y;

            }

            SAKTAN sktn = new SAKTAN();
            System.out.print(sktn.operationOnMatrix(mat, row, col, query, m));

            if (t != 0)
                System.out.println();

        } // end of while loop

    } // end of main()

} // end of class
