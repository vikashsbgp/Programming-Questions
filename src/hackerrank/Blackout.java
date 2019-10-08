package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Blackout {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        String s[] = br.readLine().split(" ");
        int arr[] = new int[N];
        int sum = 0, index = -1;
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(s[i]);
            if (sum + arr[i] <= M) {
                sum += arr[i];
                index++;
            }

        }
        int result[] = new int[N];

        Blackout b = new Blackout();

        for (int i = ++index; i < N; i++) {

            int diff = M - arr[i];
            result[i] = b.removeElement(arr, i, diff);

        }


        for (int i = 0; i < N; i++)
            System.out.print(result[i] + " ");


    }

    public int removeElement(int arr[], int last_index, int M) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < last_index; i++)
            pq.add(arr[i]);

        int sum = 0, count = 0;
        while (sum < M) {

            int tmp = pq.peek();
            sum += pq.poll();
            count++;
            if (sum == M)
                break;
            if (sum > M) {
                count--;
                sum -= tmp;
            }

        }

        return arr.length - count;

    }

}
