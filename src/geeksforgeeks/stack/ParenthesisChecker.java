package geeksforgeeks.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == '}' && !st.isEmpty()) {
                    if (st.peek() == '{')
                        st.pop();
                }
                else if (s.charAt(i) == ')' && !st.isEmpty()) {
                    if (st.peek() == '(')
                        st.pop();
                }
                else if (s.charAt(i) == ']' && !st.isEmpty()) {
                    if (st.peek() == '[')
                        st.pop();
                }
                else
                    st.push(s.charAt(i));

            }

            if (st.isEmpty())
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }

    }

}
