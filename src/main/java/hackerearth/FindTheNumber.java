package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheNumber {

    static  String solution(String s, int m, long k) {
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            int state = 0;
            for (int j = 0; i < s.length() && j < m; ++j, ++i) {
                state |= (1 << (s.charAt(i) - '0'));
            }
            v.add(state);
        }
        --k;
        String r = "";
        for (int i = v.size() - 1; i >= 0; --i) {
            List<Integer> d = new ArrayList<>();
            for (int j = 0; j < 10; ++j) {
                int tmp = v.get(i);
                int tmp1 = 1 << j;
                if ((tmp & tmp1) != 0) {
                    d.add(j);
                }
            }
            r = d.get((int) (k % d.size())) + "" + r;
            k /= d.size();
        }
        return r;


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nxk = br.readLine().trim().split(" ");
        int N = Integer.parseInt(nxk[0]);
        int X = Integer.parseInt(nxk[1]);
        int K = Integer.parseInt(nxk[2]);
        String s = br.readLine().trim();
        System.out.println(solution(s, X, K));
    }

}
