package main.java.skillenza;

import java.io.*;
import java.util.*;

class Item{
    String name;
    Integer quantity;

    Item(String name,int quantity){
        this.name= name;
        this.quantity= quantity;
    }
}

class ItemComparable implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        if(o1.quantity>o2.quantity)
            return -1;
        else if (o1.quantity<o2.quantity)
            return 1;
        else
            return o1.name.compareTo(o2.name);
    }
}

public class TopProduct2 {

    private static Map<String,Item> map = new HashMap<>();
    private static PriorityQueue<Item> pq = new PriorityQueue<>();
    private static Stack<Item> stack = new Stack<>();

    public static void main(String s[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            map.clear();
            pq.clear();
            stack.clear();
            while(n-->0){

                String in[] = br.readLine().trim().split(" ");

                if (in.length == 1) {
                    getTopItems(bw);
                }
                else
                    insertItems(in[0],Integer.parseInt(in[1]));
            }
        }
        br.close();
        bw.close();
    }

    private static void insertItems(String name, int quantity) {

        if(map.containsKey(name)){
            pq.remove(map.get(name));
            map.get(name).quantity+=quantity;
            pq.add(map.get(name));
        }
        else {
            Item obj = new Item(name,quantity);
            map.put(name,obj);
            pq.add(obj);
        }

    }

    private static void getTopItems(BufferedWriter bw) throws IOException {

        Item topItem = pq.poll();
        bw.write(topItem.quantity + " ");
        stack.push(topItem);

        while (topItem.quantity == pq.peek().quantity) {
            stack.push(pq.peek());
            bw.write(pq.peek().quantity + " ");
            pq.poll();
        }
        while (!stack.isEmpty()) {
            pq.add(stack.pop());
        }
        bw.write("\n");

    }

}
