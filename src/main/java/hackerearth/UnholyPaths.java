package main.java.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tree {

    int data;
    List<Tree> child;
    boolean temple;

    Tree (int data, boolean temple) {
        this.data = data;
        this.child = new ArrayList<>();
        this.temple = temple;
    }

}
public class UnholyPaths {

    private static Map<Integer, Tree> treeRef = new HashMap<>();

    public int getAllPaths(int n, int k, int[][] edges, int[] temples) {

        int ans = 0;
        Tree root = new Tree(1, false);
        treeRef.put(1, root);

        for (int i = 0; i < n - 1; ++i) {

            int u = edges[i][0];
            int v = edges[i][1];
            Tree node = null;
            if (treeRef.containsKey(u))
                node = treeRef.get(u);

            else {
                node = new Tree(u, false);
                treeRef.put(u, node);
            }

            if (!treeRef.containsKey(v)) {
                Tree tree = new Tree(v, false);
                treeRef.put(v, tree);
            }
            node.child.add(treeRef.get(v));

        }

        for (int i = 0; i < temples.length; ++i) {

            if (treeRef.containsKey(temples[i]))
                treeRef.get(temples[i]).temple = true;

        }

        ans = traverseTree(root, ans);

        return ans;

    }

    private int traverseTree(Tree root, int ans) {

        int count = 0;
        for (int i = 0; i < root.child.size(); ++i) {
            
        }
        return 0;
    }

    public static void main(String[] args) {



    }

}
