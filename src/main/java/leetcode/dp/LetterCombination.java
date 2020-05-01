package leetcode.dp;

import java.util.*;

public class LetterCombination {

    private static List<String> ans = new ArrayList<>();
    private static Map<String, String> hm = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        hm.put("2", "abc");
        hm.put("3", "def");
        hm.put("4", "ghi");
        hm.put("5", "jkl");
        hm.put("6", "mno");
        hm.put("7", "pqrs");
        hm.put("8", "tuv");
        hm.put("9", "wxyz");

        int s = digits.length();
        solve("", digits);
        return ans;

    }

    private void solve(String perm, String digits) {

        if (digits.length() == 0)
            ans.add(perm);
        else {
            String digit = digits.substring(0, 1);
            String str = hm.get(digit);
            for (int i = 0; i < str.length(); i++) {

                String tmp = str.substring(i, i+ 1);
                solve(perm + tmp, digits.substring(1));

            }

        }

    }

    public static void main(String[] args) {

        String s = "23";
        LetterCombination obj = new LetterCombination();
        System.out.print(obj.letterCombinations(s));

    }

}
