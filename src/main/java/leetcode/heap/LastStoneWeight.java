package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++)
            pq.add(stones[i]);
        int a = -1, b = -1;
        while (!pq.isEmpty()) {

            a = pq.poll();
            if (!pq.isEmpty())
                b = pq.poll();

            if (a == b)
                a = 0;
            else {
                pq.add(Math.abs(a - b));
            }
        }

        return a;

    }

    public static void main(String[] args) {

        int[] arr = {2,7,4,1,8,1};
        LastStoneWeight lsw = new LastStoneWeight();
        System.out.println(lsw.lastStoneWeight(arr));

    }

}