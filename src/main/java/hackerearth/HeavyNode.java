package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

class Graph {

    private int V;
    public LinkedList<Integer> parent[];
    public LinkedList<Integer> adj[];

    Graph(int v) {

        this.V = v;
        adj = new LinkedList[v+1];
        parent = new LinkedList[v + 1];

        for (int i = 1; i <= v; ++i) {
            adj[i] = new LinkedList();
            parent[i] = new LinkedList();
        }

    }

    void addEdge(int v, int w) {
        parent[w].add(v);
        adj[v].add(w);
    }
}

public class HeavyNode {

    static int divSum(int n)
    {

        int result = 0;

        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0)
            {
                if (i == (n / i))
                    result += i;
                else
                    result += (i + n / i);
            }
        }

        return (result + n + 1);

    }

    static int isHeavy(int d) {
        return divSum(d) % 3 == 0 ? 1:0;
    }

    public int DFS(int v, boolean visited[], LinkedList<?> adj[], int[] power,int[] specialNumber) {

        visited[v] = true;
        Iterator<?> itr = adj[v].listIterator();

        if (!itr.hasNext()) {

            power[v] = isHeavy(specialNumber[v]);
            return power[v];
        }

        while (itr.hasNext()) {
            Integer n = (Integer) itr.next();
            if (!visited[n]) {
                power[v] += DFS(n, visited, adj, power, specialNumber);
            }

        }

        return power[v];

    }

    public void updateSpecialNumber(LinkedList<?> parent[], int[] power, int X, boolean flag) {

        Iterator<?> itr = parent[X].listIterator();

        while (itr.hasNext()) {
            Integer n = (Integer) itr.next();
            if (flag)
                power[n]++;
            else
                power[n]--;
            updateSpecialNumber(parent, power, n, flag);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nq[] = br.readLine().split(" ");
        int N = Integer.parseInt(nq[0]);
        int Q = Integer.parseInt(nq[1]);

        Graph graph = new Graph(N);

        for (int i = 0; i < N - 1; i++) {
            String str[] = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            graph.addEdge(u,v);
        }

        boolean visited[] = new boolean[N + 1];

        HeavyNode hn = new HeavyNode();

        int specialNumber[] = new int[N + 1];
        int power[] = new int[N + 1];
        boolean isHeavyArr[] = new boolean[N + 1];

        String s[] = br.readLine().split(" ");

        for (int i = 0; i < N; i++)
            specialNumber[i + 1] = Integer.parseInt(s[i]);

        for (int i = 1; i <= N; i++) {
            power[i] = isHeavy(specialNumber[i]);
            isHeavyArr[i] = power[i] == 1 ? true : false;
        }

        power[1] = hn.DFS(1, visited, graph.adj, power, specialNumber);

        for (int i = 0; i < Q; i++) {
            int X, Y;
            String str[] = br.readLine().split(" ");
            if (str[0].equals("1")) {

                X = Integer.parseInt(str[1]);
                Y = Integer.parseInt(str[2]);
                boolean flag = false;

                if (isHeavyArr[X] && isHeavy(Y) != 1) {
                    specialNumber[X] = Y;
                    power[X]--;
                    isHeavyArr[X] = false;
                    hn.updateSpecialNumber(graph.parent, power, X, flag);
                }
                else if (!isHeavyArr[X] && isHeavy(Y) == 1) {
                    specialNumber[X] = Y;
                    power[X]++;
                    flag = true;
                    isHeavyArr[X] = true;
                    hn.updateSpecialNumber(graph.parent, power, X, flag);
                }

            }
            else {
                X = Integer.parseInt(str[1]);
                System.out.println(power[X]);
            }
        }

    }
}
