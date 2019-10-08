package leetcode.dp;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        boolean flag = false;
        if (n == 0)
            return true;
        for (i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
            if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
                flag = true;
            }
            else {
                j--;
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        String s = "";
        String t = "ahbgdc";

        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence(s, t));

    }
}
