package geeksforgeeks.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class frequencyClass {

    private int element;
    private int freq;
    private int order;

    frequencyClass(int element, int freq, int order) {
        this.element = element;
        this.freq = freq;
        this.order = order;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "frequencyClass{" +
                "element=" + element +
                ", freq=" + freq +
                ", order=" + order +
                '}';
    }
}

class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        frequencyClass obj1 = (frequencyClass)o1;
        frequencyClass obj2 = (frequencyClass)o2;

        if (obj1.getFreq() > obj2.getFreq())
            return obj1.getElement();
        else if (obj1.getFreq() < obj2.getFreq())
            return obj2.getElement();
        else {
            if (obj1.getOrder() < obj2.getOrder())
                return obj1.getElement();
            else
                return obj1.getElement();
        }

    }
}

public class SortElementByFrequency {

    public static void sortElementByFrequency(int[] arr) {

        Map<Integer, frequencyClass> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            if (hm.containsKey(arr[i]))
                hm.get(arr[i]).setFreq(hm.get(arr[i]).getFreq() + 1);
            else
                hm.put(arr[i], new frequencyClass(arr[i], 1, i));

        }

        List<frequencyClass> list = new ArrayList<>(hm.values());

        Collections.sort(list, Comparator.comparing(frequencyClass::getFreq,
                Collections.reverseOrder()).thenComparing(frequencyClass::getOrder));

        for (frequencyClass obj : list) {
            for (int i = 0; i < obj.getFreq(); i++)
                ans.add(obj.getElement());
        }

        for (int i = 0; i < ans.size(); i++) {

            System.out.print(ans.get(i));
            if (i != n - 1)
                System.out.print(" ");

        }

    }

    public static void sortElementByFrequencyUsingPriorityQueue (int[] arr) {

        int n = arr.length;
        PriorityQueue<frequencyClass> pq = new PriorityQueue<>(new MyComparator());
        Map<Integer, frequencyClass> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (hm.containsKey(arr[i]))
                hm.get(arr[i]).setFreq(hm.get(arr[i]).getFreq() + 1);
            else
                hm.put(arr[i], new frequencyClass(arr[i], 1, i));

        }

        for (Map.Entry<Integer, frequencyClass> entry : hm.entrySet())
            pq.add(entry.getValue());

        int k = pq.size();

        while (k-- > 0)
            System.out.print(pq.poll().getElement() + " ");

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {


            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);

            //sortElementByFrequency(arr);

            sortElementByFrequencyUsingPriorityQueue(arr);

            if (t != 0)
                System.out.println();

        }

    }

}
