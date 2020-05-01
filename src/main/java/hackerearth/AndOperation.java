package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndOperation {

    public static void solve(int arr[][], int el, int ind)
    {
        for(int i = 0; i < 30; ++i)
        {
            if(((1 << i) & el) != 0)
            {
                arr[ind][i] = 1;
            }
            else
            {
                arr[ind][i] = 0;
            }
            if(ind > 1)
            {
                arr[ind][i] += arr[ind - 1][i];
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str1[0]);
        int q = Integer.parseInt(str1[1]);
        String[] str2 = br.readLine().trim().split(" ");
        int arr[][] = new int[100005][30], ch[][] = new int[100005][30];

        for (int i = 0; i < n; ++i) {
            int tmp = Integer.parseInt(str2[i]);
            solve(arr, tmp, i + 1);
        }

        while (q-- > 0) {

            String[] str3 = br.readLine().trim().split(" ");
            int l = Integer.parseInt(str3[0]);
            int r = Integer.parseInt(str3[1]);
            int v = Integer.parseInt(str3[2]);

            for(int i = 0; i < 30; ++i)
            {
                if(((1 << i) & v) != 0)
                {
                    continue;
                }
                else
                {
                    ch[r][i] += -1;
                    ch[l-1][i] += 1;
                }
            }

        }

        for(int i = n; i >= 1; --i)
        {
            for(int j = 0; j < 30; ++j)
            {
                ch[i][j] += ch[i + 1][j];
            }
        }

        for(int i = 1; i <= n; ++i)
        {
            int ans = 0;
            for(int j = 0; j < 30; ++j)
            {
                if(ch[i][j] < 0)
                {
                    continue;
                }
                else
                {
                    int tmp = arr[i][j] - arr[i - 1][j];
                    ans += (tmp * (1 << j));
                }
            }
            System.out.print(ans + " ");
        }


    }

}
