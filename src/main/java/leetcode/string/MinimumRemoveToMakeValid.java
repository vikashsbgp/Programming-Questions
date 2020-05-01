package main.java.leetcode.string;

import java.util.Stack;

class Temp {

    char ch;
    int index;

    Temp(char ch, int index) {
        this.ch = ch;
        this.index = index;
    }

}

public class MinimumRemoveToMakeValid {

    public static String minRemoveToMakeValid(String s) {

        Stack<Temp> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); ++i) {

            char ch = s.charAt(i);
            if (stack.isEmpty() && ch == ')')
                stack.push(new Temp(ch, i));
            else if (!stack.isEmpty() && stack.peek().ch == '(' && ch == ')')
                stack.pop();
            else if (ch == '(' || ch == ')')
                stack.push(new Temp(ch, i));

        }

        while (!stack.isEmpty()) {

            int index = stack.pop().index;
            sb.deleteCharAt(index);

        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(MinimumRemoveToMakeValid.minRemoveToMakeValid("())()((("));

    }

}
