package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LeadersArray {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(str[i]);

            Stack<Integer> st = new Stack<>();

            for (int i = N -1; i >= 0; i--) {

                if (st.isEmpty())
                    st.push(arr[i]);

                else if (arr[i] >= st.peek())
                    st.push(arr[i]);
            }

            while (!st.isEmpty()) {
                System.out.print(st.pop());
                if (!st.isEmpty())
                    System.out.print(" ");
            }

            System.out.println();
        }

    }

}
