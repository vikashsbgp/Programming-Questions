package main.java.skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitPermutation {

    static int[] num_to_bits = new int[] { 0, 1, 1, 2, 1, 2, 2,
            3, 1, 2, 2, 3, 2, 3, 3, 4 };

    public int bitPermutation(int n) {

        int sum = 0;
        int freq0 = 0, freq1 = 0;
        String binaryString = Integer.toBinaryString(n);

        freq1 = countSetBitsRec(n);
        freq0 = binaryString.length() - freq1;

        String minBinaryString = "", maxBinaryString = "";

        for (int i = 0; i < freq0; ++i)
            minBinaryString += "0";

        for (int i = 0; i < freq1; ++i)
            minBinaryString += "1";

        for (int i = 0; i < freq1; ++i)
            maxBinaryString += "1";

        for (int i = 0; i < freq0; ++i)
            maxBinaryString += "0";

        int minVal = Integer.parseInt(minBinaryString, 2);
        int maxVal = Integer.parseInt(maxBinaryString, 2);
        int totalPossiblePerm = ncr(freq0 + freq1, freq0);
        int count = 1;
        boolean[] arr = new boolean[maxVal + 1];
        int tmp = minVal;
        arr[tmp] = true;
        sum += tmp;
        while (tmp << 1 <= maxVal) {
            tmp = tmp << 1;
            arr[tmp] = true;
            sum += tmp;
            count++;
        }

        for (int i = minVal + 1; i <= maxVal; ++i) {

            if (count == totalPossiblePerm)
                break;
            if (arr[i])
                continue;
            if (countSetBitsRec(i) == freq1) {
                arr[i] = true;
                sum += i;
                count++;
                tmp = i;
                while (tmp << 1 <= maxVal) {
                    tmp = tmp << 1;
                    arr[tmp] = true;
                    sum += tmp;
                    count++;
                }
            }

        }

        return sum;

    }

    int ncr(int n, int k)
    {
        int res = 1;

        if ( k > n - k )
            k = n - k;

        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    int countSetBitsRec(int num)
    {
        int nibble = 0;
        if (0 == num)
            return num_to_bits[0];

        nibble = num & 0xf;
        return num_to_bits[nibble] + countSetBitsRec(num >> 4);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            BitPermutation bp = new BitPermutation();
            System.out.print(bp.bitPermutation(n));
            if (t != 0)
                System.out.println();
        }

    }

}
