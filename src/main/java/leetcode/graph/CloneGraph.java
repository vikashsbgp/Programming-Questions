package leetcode.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {


        return null;
    }

    public Node push(Node node) {
        Node tmp = new Node(node.val, new ArrayList<>());
        return tmp;
    }

    public static void main(String[] args) {

    }

}
