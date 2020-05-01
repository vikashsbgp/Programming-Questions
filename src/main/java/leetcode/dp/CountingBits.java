package leetcode.dp;

public class CountingBits {

    public int[] countBits(int num) {

        int[] ans = new int[num + 1];

        if (num == 0)
            return ans;

        ans[1] = 0;

        for (int i = 0; i <= num; i++) {

            int rem = i % 2;
            int q = i / 2;
            ans[i] = rem + ans[q];

        }

        return ans;

    }

    public static void main(String[] args) {

        int n = 8;
        CountingBits obj = new CountingBits();
        for (int e :
             obj.countBits(n)) {
            System.out.print(e + " ");
        }

    }

}
