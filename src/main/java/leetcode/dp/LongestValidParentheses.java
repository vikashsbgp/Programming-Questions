package leetcode.dp;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int maxCount = 0, count = 0;



        return maxCount * 2;

    }

    public static void main(String[] args) {

        String s = "(()";
        LongestValidParentheses obj = new LongestValidParentheses();
        System.out.print(obj.longestValidParentheses(s));

    }

}
