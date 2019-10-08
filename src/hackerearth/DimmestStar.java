package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DimmestStar {
    static HashMap<Integer, ArrayList<Integer> > hm = new HashMap<>();
    static HashMap<Integer, TreeNode> ref = new HashMap<>();
    class TreeNode {
        int val;
        int height;
        ArrayList<TreeNode> siblings;

        TreeNode(int x, int h) {
            val = x;
            height = h;
            this.siblings = new ArrayList<>();
        }

    }



    public void create(int start) {
        TreeNode tn = null;
        if(!ref.containsKey(start))
        {	tn = new TreeNode(start, 0);
            ref.put(start, tn);
        }
        else
            tn=ref.get(start);

        ArrayList<Integer> child =hm.get(start);

        for (int i : child) {
            TreeNode cNode = new TreeNode(i,tn.height+1);
            tn.siblings.add(cNode);
            ref.put(i,cNode);
            if(hm.containsKey(i))
                create(i);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n - 1; i++) {

            String s[] = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            if (hm.containsKey(a)) {
                hm.get(a).add(b);
            }
            else {

                hm.put(a,new ArrayList<>());
                hm.get(a).add(b);
            }

        }

        int start  = Integer.parseInt(br.readLine().trim());

        DimmestStar ds = new DimmestStar();

        if (hm.containsKey(start))
            ds.create(start);
        else
            System.out.println("Something went Wrong");

        int val=0,mxHeight=-1;
        for (Map.Entry<Integer,TreeNode> temp:ref.entrySet()) {
            if(mxHeight<temp.getValue().height)
            {
                mxHeight=temp.getValue().height;
                val=temp.getValue().val;
            }
        }
        System.out.println(val);
    }

}

