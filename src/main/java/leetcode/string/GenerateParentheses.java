package main.java.leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0) return res;

        DFS(0,0,new StringBuilder(), n);

        return res;
    }

    public void DFS(int left, int right, StringBuilder sb, int n){
        if(left > n || right > n || right > left) return;

        if(left == n && right == n){
            res.add(sb.toString());
        }

        DFS(left + 1, right, sb.append('('), n);
        sb.setLength(sb.length() - 1);

        DFS(left, right+1, sb.append(')'), n);
        sb.setLength(sb.length() - 1);

    }

    public static void main(String[] args) {

        System.out.println(new GenerateParentheses().generateParenthesis(6));

    }

}
