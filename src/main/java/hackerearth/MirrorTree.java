package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Node {

    int data;
    Node left, right, parent;

    Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}
public class MirrorTree {

    private static Map<Integer, Node> ref = new HashMap<>();

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nq = br.readLine().split(" ");
        int N = Integer.parseInt(nq[0]);
        int Q = Integer.parseInt(nq[1]);
        Node root = null;
        Node tmp = null;

        for (int i = 0; i < N - 1 ; ++i) {

            String[] str = br.readLine().trim().split(" ");
            int parentData = Integer.parseInt(str[0]);
            int childData = Integer.parseInt(str[1]);
            char childDir = str[2].charAt(0);
            if (i == 0) {
                root = new Node(parentData);
                tmp = root;
                ref.put(parentData, root);
            }
            else
                tmp = new Node(parentData);

            tmp = push(childData, childDir, tmp);

            ref.put(childData, tmp);
        }

        for (int i = 0; i < Q; ++i) {
            System.out.println(getMirrorData(Integer.parseInt(br.readLine().trim())));
        }

    }

    public static Node push(int data, char child, Node parent) {

        Node node = new Node(data);
        if (child == 'L')
            parent.left = node;
        else
            parent.right = node;

        return node;

    }

    public static int getMirrorData(int data) {

        Node node = ref.get(data);
        node = node.parent;
        if (node.left.data == data)
            return node.right.data;
        else if (node.right.data == data)
            return node.left.data;
        else
            return -1;

    }

}
