package codinggame;

import java.util.LinkedList;
import java.util.Queue;

public class ChefGusteau {

    public static String solve(String ing) {

        StringBuilder sb = new StringBuilder("00");
        Queue<Character> q = new LinkedList<>();
        int[] count = new int[3];

        q.add(ing.charAt(0));
        count[ing.charAt(0) - 65] = 1;
        if (ing.charAt(0) != ing.charAt(1)) {
            q.add(ing.charAt(1));
            count[ing.charAt(1) - 65] = 1;
        }
        else
            count[ing.charAt(1) - 65]++;

        for (int i = 2; i < ing.length(); ++i) {

            int tmp = ++count[ing.charAt(i) - 65];
            if (tmp > 1 && q.size() >= 1) {
                sb.append("1");
                count[ing.charAt(i) - 65] = tmp - 2;
                q.remove(ing.charAt(i));
                char ch;
                if (q.size() != 0 && ing.charAt(i) != q.peek()) {
                    ch = q.remove();
                    count[ch - 65]--;
                }
                else
                    --count[ing.charAt(i) - 65];
            }
            else {
                sb.append("0");
                q.add(ing.charAt(i));
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(solve("AAABAAAAABBC"));

    }

}
