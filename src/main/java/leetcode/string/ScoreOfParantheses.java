package leetcode.string;

import java.util.ArrayList;
import java.util.List;

class Node {

    List<Node> child;
    Node parent;

    Node (Node parent) {
        this.child = new ArrayList<>();
        this.parent = parent;
    }
}

public class ScoreOfParantheses {

    public Node createTree(String str, int n) {

        Node root = new Node(null);
        Node tmp = root;
        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == '(') {
                tmp = push(tmp);
            }
            else {
                tmp = tmp.parent;
            }

        }

        return root;

    }

    public Node push (Node node) {

        Node tmp = new Node(node);
        node.child.add(tmp);
        return tmp;

    }

    public int scoreOfParentheses(String S) {

        int n = S.length();
        int ans = 0;
        Node root = createTree(S, n);

        for (Node child : root.child) {
            ans += solve(child);
        }

        return ans;

    }

    private int solve(Node node) {

        int ans = 0;
        if (node.child.size() == 0)
            return 1;
        for (Node child : node.child) {
            ans += 2 * solve(child);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "(())";
        ScoreOfParantheses sop = new ScoreOfParantheses();
        System.out.print(sop.scoreOfParentheses(s));
    }

}
