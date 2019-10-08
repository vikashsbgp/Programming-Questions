package skillenza;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int height;
    List<Node> child;
    Node parent;

    Node (int height, Node parent) {
        this.height = height;
        this.child = new ArrayList<>();
        this.parent = parent;
    }
}

public class BracketExpression {

    public Node createTree(String str, int n) {

        Node root = new Node(0, null);
        Node tmp = root;
        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == '[') {
                tmp = push(tmp);
            }
            else {
                tmp = tmp.parent;
            }

        }

        return root;

    }

    public int getMaxNumberOfChildren(Node root, Map<Integer, Integer> hm) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node tmp = null;
        int height = 0, maxNode = 0, count = 0;
        //boolean flag = false;

        while (!queue.isEmpty()) {

            if (queue.peek() == null) {
                queue.poll();
                queue.add(null);
                ++height;
                hm.put(height, count);
                if (maxNode < count)
                    maxNode = count;
                count = 0;
            }
            else {

                tmp = queue.poll();
                count += tmp.child.size();

                for (int i = 0; i < tmp.child.size(); i++)
                    queue.add(tmp.child.get(i));

            }

            if (queue.size() == 1 && queue.peek() == null) {
                break;
            }

        }

        return maxNode;

    }

    public Node push (Node node) {

        Node tmp = new Node(node.height + 1, node);
        node.child.add(tmp);
        return tmp;

    }

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {

                Map<Integer, Integer> hm = new HashMap<>();
                int n = Integer.parseInt(br.readLine().trim());
                String str = br.readLine().trim();

                int[] ans = new int[4];
                BracketExpression be = new BracketExpression();
                Node root = be.createTree(str, str.length());
                int maxNode = be.getMaxNumberOfChildren(root, hm);
                int count = 0;

                for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                    if (maxNode == entry.getValue())
                        count++;
                }

                ans[0] = n / 2;
                ans[1] = hm.size();
                ans[2] = maxNode;
                ans[3] = count;

                for (int i = 0; i < ans.length; i++) {
                    System.out.print(ans[i]);
                    if (i != ans.length - 1)
                        System.out.print(" ");
                }

                if (t != 0)
                    System.out.println();

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

}
