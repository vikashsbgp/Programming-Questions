package main.java.geeksforgeeks.string;

import java.util.Comparator;
import java.util.PriorityQueue;

class Frequency {

    char ch;
    int freq;

    Frequency(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

}

class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Frequency frequency1 = (Frequency)o1;
        Frequency frequency2 = (Frequency)o2;
        Integer freq1 = frequency1.freq;
        Integer freq2 = frequency2.freq;
        if (freq1 < freq2)
            return freq2;
        else
            return freq1;
    }
}
public class RearrangeString {

    public static String rearrangeString(String s) {

        StringBuilder sb = new StringBuilder("");
        PriorityQueue<Frequency> pq = new PriorityQueue<>(new MyComparator());
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); ++i)
            arr[s.charAt(i) - 97]++;

        for (int i = 0; i < 26; ++i) {

            if (arr[i] != 0)
                pq.add(new Frequency((char)(97 + i), arr[i]));

        }

        Frequency key = new Frequency('#', -1);
        while (!pq.isEmpty()) {

            Frequency k = pq.poll();
            sb.append(k.ch);
            if (key.freq > 0) {
                pq.add(key);
            }
            k.freq--;
            key = k;

        }

        if (sb.length() != s.length())
            return "Not Valid String";
        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(RearrangeString.rearrangeString("aaabc"));

    }

}
