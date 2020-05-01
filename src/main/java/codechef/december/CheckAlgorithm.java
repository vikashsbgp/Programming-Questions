package main.java.codechef.december;

public class CheckAlgorithm {

    public static String checkAlgorithm(String s) {

        String ans = "NO";
        int buffer = 0;
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); ++i)
            arr[s.charAt(i) - 97]++;

        for (int i = 0; i < 26; ++i) {

            int digit = 0;
            if (arr[i] != 0) {

                if (arr[i] > 2)
                    buffer += arr[i] - countDigit(arr[i]);
                else if (arr[i] == 1)
                    buffer--;

            }

        }

        if (buffer > 1)
            ans = "YES";

        return ans;

    }

    private static int countDigit(int n) {

        return (int)Math.floor(Math.log10(n) + 1);

    }

    public static void main(String[] args) {

        System.out.println(CheckAlgorithm.checkAlgorithm("abcdefghijkkkkkkkkkklllll"));

    }

}
